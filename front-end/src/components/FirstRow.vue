<template>
    <div class="go-diary-container">
        <div class="left-btns">
            <!-- Left Buttons -->
            <!-- router 임의 설정, 나중에 바꿔서 해당 router로 push -->
            <Buttons btn-text="일기작성" @click="onOpenPersonalRecording" />
            <Buttons
                class="write-with-diary"
                btn-text="함께쓰기"
                @click="showWithModal = !showWithModal"
            />
        </div>

        <div class="right-btns">
            <!-- Search -->
            <div class="search">
                <div @click="searchDiary" class="material-icons">search</div>
            </div>
            <!-- Right Buttons -->
            <!-- <Buttons class="search-filter" btn-text="필터" /> -->
        </div>

        <!-- 일기 작성 modal -->
        <Recording
            :open="OpenPersonalRecording"
            :session="session"
            :publisher="publisher"
            :mainStreamManager="mainStreamManager"
            :subscribers="subscribers"
            @closeRecording="leaveSession"
            @recordingStart="recordingStart"
            @recordingStop="recordingStop"
        />

        <!-- 함께 쓰기 modal -->
        <va-modal v-model="showWithModal" hide-default-actions>
            <b>추억을 저장 해보세요</b>
            <div class="group-btns">
                <WhiteButtons
                    class="mx-2"
                    white-btn-text="방생성"
                    @click="onOpenRecording"
                />
                <Buttons
                    class="mx-2"
                    btn-text="방 검색"
                    @click="MoveSearchModal"
                />
            </div>
        </va-modal>

        <!-- 방 생성 modal -->
        <GroupRecording
            ref="groupRecordingRef"
            :open="openRecording"
            :session="session"
            :publisher="publisher"
            :mainStreamManager="mainStreamManager"
            :subscribers="subscribers"
            :recordingStatus="recordingStatus"
            :currentUserId="currentUserId"
            :isMyOrder="isMyOrder"
            :tossArray="tossArray"
            :userListStr="userListStr"
            :isFinalUser="isFinalUser"
            :videoLink="videoLink"
            :diaryGroupId="diaryGroupId"
            :chattingObjArray="chattingObjArray"
            @closeRecording="leaveSession"
            @recordingStart="recordingStart"
            @recordingStop="recordingStop"
            @isMyOrderSwitch="isMyOrderSwitch"
            @setUserListStr="setUserListStr"
        />
        <!-- <DiaryDetail
      :move="moveDiaryDetail"
      :recordingUrl="recordingUrl"
      :diaryContent="diaryContent"
      @closeDetail="this.moveDiaryDetail = !this.moveDiaryDetail"
    /> -->

        <!-- 화면 녹화 디테일 Modal -->
        <DiaryRecordingDetail
            :move="moveDiaryRecordingDetail"
            :recordingUrl="recordingUrl"
            :diaryContent="diaryContent"
            @closeDetail="
                this.moveDiaryRecordingDetail = !this.moveDiaryRecordingDetail
            "
        />
        <!-- 방 검색 modal -->
        <va-modal v-model="showSearchModal" hide-default-actions>
            <b>방에 참여 하시겠습니까?</b>
            <div class="search">
                <input
                    v-model="roomCode"
                    type="text"
                    placeholder="내용을 입력해주세요."
                />
                <div class="material-icons">search</div>
            </div>
            <div class="group-btns">
                <WhiteButtons
                    class="mx-2"
                    white-btn-text="취소"
                    @click="CloseSearchModal"
                />
                <Buttons class="mx-2" btn-text="참여하기" @click="joinGroup" />
            </div>
        </va-modal>
    </div>
    <hr />
</template>

<script>
import Buttons from "./Buttons.vue";
import WhiteButtons from "./WhiteButtons.vue";
import { OpenVidu } from "openvidu-browser";
import Recording from "./Recording.vue";
import GroupRecording from "./GroupRecording.vue";
import DiaryRecordingDetail from "./DiaryRecordingDetail.vue";
import axios from "axios";

axios.defaults.headers.post["Content-Type"] = "application/json";
// axios.defaults.baseURL = "/api/v1";
const OPENVIDU_SERVER_URL = "https://" + location.hostname + ":4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
    components: {
        Buttons,
        WhiteButtons,
        Recording,
        GroupRecording,
        DiaryRecordingDetail,
    },
    data() {
        return {
            openRecording: false,
            OpenPersonalRecording: false,
            moveDiaryDetail: false,
            moveDiaryRecordingDetail: false,
            showWithModal: false,
            showSearchModal: false,
            searchTitle: "",
            joinGroupId: "",
            searchData: [],
            // userId: "giho3", // sessionId를 userId로 대체
            recordingId: null,
            recordingUrl: null,
            diaryContent: [],
            diaryId: 1,
            videoLink: null,
            diaryGroupId: null,

            OV: undefined,
            session: undefined,
            mainStreamManager: undefined,
            publisher: undefined,
            subscribers: [],
            // sessionId: 'SessionA',
            roomCode: "", // roomCode는 방을 만든 사람의 userId값
            // myName: "testUser" + Math.random() * 100,

            recordingStatus: "beforeStarted",
            // currentUserId: "",
            isMyOrder: false,
            tossArray: [],
            userListStr: "",
            isFinalUser: false,

            chattingObjArray: [
                { user: "system", message: "채팅을 시작합니다." },
            ],
        };
    },
    methods: {
        isMyOrderSwitch() {
            this.isMyOrder = !this.isMyOrder;
        },
        setUserListStr() {
            let userArray = this.tossArray.slice(1);

            for (let i = 0; i < userArray.length; i++) {
                if (i !== userArray.length - 1)
                    this.userListStr += userArray[i].connectionId + ",";
                else this.userListStr += userArray[i].connectionId;
            }
            console.log(this.userListStr);
        },
        /**
         * 함께쓰기 시 모달 창을 열고 Openvidu 세션을 생성하는 함수
         */
        onOpenPersonalRecording() {
            this.OpenPersonalRecording = !this.OpenPersonalRecording;
            this.createRoom();
        },

        onOpenRecording() {
            this.openRecording = !this.openRecording;
            this.createRoom();
        },
        MoveSearchModal() {
            this.showSearchModal = !this.showSearchModal;
            this.showWithModal = !this.showWithModal;
        },
        CloseSearchModal() {
            this.showSearchModal = !this.showSearchModal;
            console.log(this.showSearchModal);
        },
        async searchDiary() {
            this.searchData = await this.api(
                "/api/diary/" + this.searchTitle,
                "get",
                {}
            ); //url
            console.log(this.searchTitle);
            console.log(this.searchData);
        },
        joinGroup() {
            this.openRecording = !this.openRecording;
            this.joinSession(this.roomCode);
        },
        /**
         * 함께쓰기 방 생성 함수
         */
        createRoom() {
            this.roomCode = this.$store.state.userId;
            this.joinSession(this.$store.state.userId);
            // this.joinSession("testUser"); // toss 테스트용 ID (주의! DB에 해당 유저 존재해야 함)
        },
        /* Openvidu API 시작 */
        joinSession(roomCode) {
            // --- Get an OpenVidu object ---
            this.OV = new OpenVidu();

            // --- Init a session ---
            this.session = this.OV.initSession();

            // --- Specify the actions when events take place in the session ---

            // On every new Stream received...
            this.session.on("streamCreated", ({ stream }) => {
                const subscriber = this.session.subscribe(stream);
                this.subscribers.push(subscriber);
            });

            // On every Stream destroyed...
            this.session.on("streamDestroyed", ({ stream }) => {
                const index = this.subscribers.indexOf(stream.streamManager, 0);
                if (index >= 0) {
                    this.subscribers.splice(index, 1);
                }
            });

            // Connection 생성시 설정
            this.session.on("connectionCreated", ({ connection }) => {
                this.tossArray.push(connection);
            });

            // Connection 삭제 설정
            this.session.on("connectionDestroyed", ({ connection }) => {
                const index = this.tossArray.indexOf(connection, 0);
                if (index >= 0) {
                    this.tossArray.splice(index, 1);
                }
            });

            // On every asynchronous exception...
            this.session.on("exception", ({ exception }) => {
                console.warn(exception);
            });

            // toss버튼 시그널 들어왔을 시
            this.session.on("signal:toss", ({ data: message }) => {
                console.log("FirstRow 토스 받음", message);
                this.userListStr = message;

                this.$refs.groupRecordingRef.faceRecognizeEmotions();
                this.$refs.groupRecordingRef.voiceTextStart();

                if (message !== "") this.isMyOrderSwitch();

                if (message === "") this.isFinalUser = true;
            });

            // 녹화 시작/종료버튼 signal 들어왔을 시
            this.session.on("signal:recordStatus", ({ data: message }) => {
                // console.log("녹화 감지", message);
                this.recordingStatus = message;
                if (message === "recordingStopped") {
                    // console.log("녹화 종료 감지");
                    this.$refs.groupRecordingRef.switchTitleModal();
                }
            });

            // 그룹번호를 받아오기 위한 signal TODO
            this.session.on("signal:group", ({ data: diaryGroupId }) => {
                // console.log("다이어리그룹 번호 받음");
                // console.log(diaryGroupId);
                this.diaryGroupId = diaryGroupId * 1;
            });

            // 영상 링크를 받아오기 위한 signal
            this.session.on("signal:videoLink", ({ data: videoLink }) => {
                // console.log("비디오링크 받음");
                // console.log(videoLink);
                this.videoLink = videoLink;
            });

            // recordingId를 받아오기 위한 signal
            this.session.on("signal:recordingId", ({ data: recordingId }) => {
                // console.log("녹화번호 받음");
                // console.log(recordingId);
                console.log(recordingId);
                this.recordingId = recordingId;
            });

            // 채팅 메시지를 받기 위함
            this.session.on("signal:group-chat", ({ data: chat }) => {
                console.log(chat);
                let chatTmp = chat.split(",");

                const chatObj = {
                    user: chatTmp[0],
                    message: chatTmp[1],
                };
                this.chattingObjArray.push(chatObj);
            });

            // --- Connect to the session with a valid user token ---

            // 'getToken' method is simulating what your server-side should do.
            // 'token' parameter should be retrieved and returned by your own backend
            // sessionId를 userId로 대체
            this.getToken(roomCode).then((token) => {
                this.session
                    .connect(token, { clientData: this.myUserName })
                    .then(() => {
                        // --- Get your own camera stream with the desired properties ---

                        let publisher = this.OV.initPublisher(undefined, {
                            audioSource: undefined, // The source of audio. If undefined default microphone
                            videoSource: undefined, // The source of video. If undefined default webcam
                            publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
                            publishVideo: true, // Whether you want to start publishing with your video enabled or not
                            resolution: "640x480", // The resolution of your video
                            frameRate: 30, // The frame rate of your video
                            insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
                            mirror: false, // Whether to mirror your local video or not
                        });

                        this.mainStreamManager = publisher;
                        this.publisher = publisher;

                        // --- Publish your stream ---

                        this.session.publish(this.publisher);
                    })
                    .catch((error) => {
                        console.log(
                            "There was an error connecting to the session:",
                            error.code,
                            error.message
                        );
                    });
            });

            window.addEventListener("beforeunload", this.leaveSession);
        },

        leaveSession() {
            // --- Leave the session by calling 'disconnect' method over the Session object ---
            if (this.session) this.session.disconnect();

            this.session = undefined;

            this.openRecording = !this.openRecording;
            this.mainStreamManager = undefined;
            this.publisher = undefined;
            this.subscribers = [];
            this.OV = undefined;

            window.removeEventListener("beforeunload", this.leaveSession);
            // this.moveDiaryRecordingDetail = !this.moveDiaryRecordingDetail;
        },
        async recordingStart() {
            // console.log("녹화 시작");
            // Face API 시작
            await axios
                .post(
                    `${OPENVIDU_SERVER_URL}/openvidu/api/recordings/start`,
                    {
                        session: this.roomCode,
                        // session: "testUser", // toss 테스트용 ID (주의! DB에 해당 유저 존재해야 함)
                    },
                    {
                        auth: {
                            username: "OPENVIDUAPP",
                            password: OPENVIDU_SERVER_SECRET,
                        },
                    }
                )
                .then((res) => {
                    console.log(res);
                    this.recordingId = res.data.id;
                    console.log(this.recordingId);

                    this.session
                        .signal({
                            data: this.recordingId, // Any string (optional)
                            to: [], // 모든 구성원에게 보내기
                            type: "recordingId", // The type of message (optional)
                        })
                        .then(() => {
                            console.log("녹화번호 전송 완료");
                        })
                        .catch((error) => {
                            console.error(error);
                        });
                });
        },
        async recordingStop() {
            // openvidu 녹화 중지 API
            console.log(this.recordingId);
            await axios
                .post(
                    `${OPENVIDU_SERVER_URL}/openvidu/api/recordings/stop/${this.recordingId}`,
                    {},
                    {
                        auth: {
                            username: "OPENVIDUAPP",
                            password: OPENVIDU_SERVER_SECRET,
                        },
                    }
                )
                .then((res) => {
                    // console.log(res);
                    // console.log(res.data.url);
                    this.recordingUrl = res.data.url;
                });

            // 녹화영상 URL 모든 참여자에게 전송
            this.session
                .signal({
                    data: this.recordingUrl, // Any string (optional)
                    to: [], // Array of Connection objects (optional. Broadcast to everyone if empty)
                    type: "videoLink", // The type of message (optional)
                })
                .then(() => {
                    console.log("비디오링크 보냄");
                })
                .catch((error) => {
                    console.error(error);
                });

            // 녹화가 끝났음을 모든 참여자에게 전송
            this.session
                .signal({
                    data: "recordingStopped", // Any string (optional)
                    to: [], // Array of Connection objects (optional. Broadcast to everyone if empty)
                    type: "recordStatus", // The type of message (optional)
                })
                .then(() => {
                    // console.log("Message successfully sent");
                })
                .catch((error) => {
                    console.error(error);
                });
        },

        updateMainVideoStreamManager(stream) {
            if (this.mainStreamManager === stream) return;
            this.mainStreamManager = stream;
        },

        /**
         * --------------------------
         * SERVER-SIDE RESPONSIBILITY
         * --------------------------
         * These methods retrieve the mandatory user token from OpenVidu Server.
         * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
         * the API REST, openvidu-java-client or openvidu-node-client):
         *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
         *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
         *   3) The Connection.token must be consumed in Session.connect() method
         */

        getToken(roomCode) {
            return this.createSession(roomCode).then((sessionId) =>
                this.createToken(sessionId)
            );
        },

        // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessions
        createSession(roomCode) {
            return new Promise((resolve, reject) => {
                axios
                    .post(
                        `${OPENVIDU_SERVER_URL}/openvidu/api/sessions`,
                        JSON.stringify({
                            customSessionId: roomCode,
                        }),
                        {
                            auth: {
                                username: "OPENVIDUAPP",
                                password: OPENVIDU_SERVER_SECRET,
                            },
                        }
                    )
                    .then((response) => response.data)
                    .then((data) => resolve(data.id))
                    .catch((error) => {
                        if (error.response.status === 409) {
                            resolve(roomCode);
                        } else {
                            console.warn(
                                `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`
                            );
                            if (
                                window.confirm(
                                    `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`
                                )
                            ) {
                                location.assign(
                                    `${OPENVIDU_SERVER_URL}/accept-certificate`
                                );
                            }
                            reject(error.response);
                        }
                    });
            });
        },

        // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessionsltsession_idgtconnection
        createToken(roomCode) {
            return new Promise((resolve, reject) => {
                axios
                    .post(
                        `${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${roomCode}/connection`,
                        {},
                        {
                            auth: {
                                username: "OPENVIDUAPP",
                                password: OPENVIDU_SERVER_SECRET,
                            },
                        }
                    )
                    .then((response) => response.data)
                    .then((data) => resolve(data.token))
                    .catch((error) => reject(error.response));
            });
        },
        /* openVidu API 끝 */
    },
};
</script>

<style scoped>
.go-diary-container {
    display: flex;
    justify-content: space-between;
}

.left-btns {
    display: inline-flex;
}

.write-with-diary {
    margin-left: 20px;
}

.right-btns {
    display: flex;
}

.search-filter {
    margin-left: 20px;
}

.search {
    position: relative;
    height: 34px;
    vertical-align: middle;
    top: 20px;
}

.search-input {
    width: 200px;
    height: inherit;
    padding: 4px 10px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 5px;
    outline: none;
    background-color: #fff;
    color: #777;
    font-size: 12px;
}

.search-input:focus {
    width: 200px;
    border-color: #000080;
}

.search .material-icons {
    height: 24px;
    position: absolute;
    top: 0;
    bottom: 0;
    right: 5px;
    margin: auto;
    cursor: pointer;
}

.search.focused .material-icons {
    opacity: 0;
}

.group-btns {
    display: flex;
    margin-top: 1.5rem;
}
</style>
