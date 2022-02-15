<template>
    <va-modal
        v-model="state.recordingVisible"
        no-outside-dismiss
        hide-default-actions
        max-height="100%"
        max-width="100%"
    >
        <div class="recording-modal">
            <div class="modal-header">
                <va-button
                    class="modal-btn"
                    color="#6565ca"
                    icon="clear"
                    @click="closeRecording"
                ></va-button>
            </div>
            
            <!-- 영상 출력 -->
            <div id="session" v-if="session">
                <div class="row justify--space-around">
                    <div class="flex md3 lg6">
                        <div id="video-container" class="flex md videocenter4">
                            <user-video :stream-manager="publisher" />
                            <user-video
                                v-for="sub in subscribers"
                                :key="sub.stream.connection.connectionId"
                                :stream-manager="sub"
                            />
                        </div>
                    </div>
                    <div class="flex md4 lg1"></div>
                    <ChatRoom class="flex md4 lg3"/>
                    <!-- <div class="flex md3 lg3">
                        <div></div>
                    </div> -->    
                </div>
            </div>
            <!-- <ChatRoom class="flex md3 lg3"/> -->
            
            <div class="row justify--center" v-if="session">
                <Buttons
                    v-show="
                        recordingStatus === 'beforeStarted' &&
                        tossArray.length === 4
                    "
                    class="mx-2"
                    btn-text="녹화 시작"
                    @click="recordingStart"
                />
                <Buttons
                    class="mx-2"
                    btn-text="toss"
                    v-show="recordingStatus === 'recordingStarted' && isMyOrder"
                    @click="tossUser"
                />
                <Buttons
                    v-show="isFinalUser"
                    class="mx-2"
                    btn-text="녹화 중지"
                    @click="recordingStop()"
                />
            </div>
        </div>
    </va-modal>
    <!-- 제목 수정 modal -->
    <va-modal v-model="state.showTitleModal" hide-default-actions>
        <div class="diaryTitleModal">

            <b>어떤 추억으로 기록하시겠어요?</b>
            <div>
            <va-input
                class="mt-4 mb-2"
                v-model="state.diaryTitle"
                placeholder="일기 제목을 입력하세요."
            />
            </div>
            <div>
            <Buttons class="mx-2" btn-text="저장하기" @click="saveDiary()" />
            </div>
        </div>
    </va-modal>

</template>

<script>
import { computed, reactive } from "vue";
import UserVideo from "./UserVideo.vue";
import Buttons from "./Buttons.vue";
import axios from "axios";
import * as faceapi from "face-api.js";
import ChatRoom from './Chat/ChatRoom.vue'
import { useStore } from "vuex";

axios.defaults.headers.post["Content-Type"] = "application/json";

export default {
    components: {
        UserVideo,
        Buttons,
        ChatRoom
    },
    name: "GroupRecording",
    props: {
        open: {
            type: Boolean,
            default: false,
        },
        session: {
            type: Object,
        },
        mainStreamManager: {
            type: Object,
        },
        publisher: {
            type: Object,
        },
        subscribers: {
            type: Array,
        },
        recordingStatus: {
            type: String,
        },
        isMyOrder: {
            type: Boolean,
        },
        tossArray: {
            type: Array,
        },
        userListStr: {
            type: String,
        },
        isFinalUser: {
            type: Boolean,
        },
        diaryGroupId: {
            type: Number,
        },
        videoLink: {
            type: String,
        },
    },
    data() {
        return {
            interval: null,
        };
    },
    created() {},
    setup(props, { emit }) {
        const store = useStore();

        const state = reactive({
            recordingVisible: computed(() => props.open),
            interval: null, // 감정정보 분석을 위한 interval을 저장
            speechRecognizer: Object, // webAPI의 음성인식 객체
            recordingText: "", // 음성인식된 텍스트를 저장
            showTitleModal: false,
            diaryTitle: ''
        });

        const myDiary = {
            title: "",
            videoLink: "",
            content: "",
            thumbNail: null,
            user: {
                userId: store.state.userId,
                // userId: "testUser", // toss 테스트용 ID (주의! DB에 해당 유저 존재해야 함)
            },
            emotions: {
                emotionsId: -1,
            },
            diaryGroup: {
                groupId: -1,
            },
        };

        const closeRecording = function () {
            emit("closeRecording");
        };
        let cnt = 0;

        // 감정정보를 담을 객체
        let statusPercent = {
            default: 0,
            neutral: 0,
            happy: 0,
            sad: 0,
            angry: 0,
            fearful: 0,
            disgusted: 0,
            surprised: 0,
        };

        /**
         * 녹화 시작 버튼 누를 시 실행되는 method
         */
        const recordingStart = async () => {
            emit("recordingStart");
            emit("isMyOrderSwitch");
            faceRecognizeEmotions();
            voiceTextStart();

            emit("setUserListStr");

            // 녹화가 시작됨을 모든 구성원에게 알림
            props.session
                .signal({
                    data: "recordingStarted", // Any string (optional)
                    to: [], // 모든 구성원에게 보내기
                    type: "recordStatus", // The type of message (optional)
                })
                .then(() => {
                    console.log("Message successfully sent");
                })
                .catch((error) => {
                    console.error(error);
                });

            // TODO
            await axios
                .post("http://localhost:8080/api/diaryGroup", {})
                .then(({ data: groupObject }) => {
                    console.log(groupObject);
                    console.log(groupObject.groupId);
                    let diaryGroupId = groupObject.groupId;

                    // 그룹 아이디를 모든 구성원에게 알림
                    props.session
                        .signal({
                            data: diaryGroupId, // 그룹 아이디를 전송
                            to: [], // 모든 구성원에게 보내기
                            type: "group", // The type of message (optional)
                        })
                        .then(() => {
                            console.log("Message successfully sent");
                        })
                        .catch((error) => {
                            console.error(error);
                        });
                });

            console.log(props.diaryGroupId);
        };

        const tossUser = async () => {
            emit("isMyOrderSwitch");
            state.speechRecognizer.stop();
            clearInterval(state.interval);

            /* 감정정보 저장 및 감정번호 받아오기 시작 */
            let myEmotions = statusPercent;
            myEmotions.user = {
                userId: store.state.userId, // 여기에는 자신의 userId가 들어와야 함.
                // userId: "testUser", // toss 테스트용 ID (주의! DB에 해당 유저 존재해야 함)
            };
            // 감정정보를 저장 후 감정 번호를 받아와야 함.
            await axios
                .post("http://localhost:8080/api/emotions", myEmotions)
                .then(({ data: emotionsObject }) => {
                    // 감정정보 대입
                    console.log(emotionsObject.emotionsId);
                    myDiary.emotions.emotionsId = emotionsObject.emotionsId;
                });
            /* 감정정보 저장 및 감정번호 받아오기 끝 */

            // console.log("내가 말한 내용은!");
            // console.log(state.recordingText);
            // console.log("내 감정 정보는!");
            // console.log(statusPercent);

            /* 다음 사람이 토스할 목록을 보내기 위한 작업 시작 */
            let userArray = props.userListStr.split(",");
            // console.log(userArray);

            let tossTarget = [];

            for (let i = 0; i < props.tossArray.length; i++) {
                console.log(props.tossArray[i].connectionId);
                if (props.tossArray[i].connectionId === userArray[0])
                    tossTarget.push(props.tossArray[i]);
            }

            let userData = "";
            for (let i = 1; i < userArray.length; i++) {
                if (i !== userArray.length - 1) userData += userArray[i] + ",";
                else userData += userArray[i];
            }

            props.session // 다음 사람에게 녹화해야 하는 유저의 목록 전송
                .signal({
                    data: userData, // ','구분자를 이용하여 유저의 목록 전송
                    to: tossTarget, // 다음 녹화 대상에게 전송
                    type: "toss", // toss 기능을 알리기 위한 type 정의
                })
                .then(() => {
                    console.log("다음 사람에게 Toss 완료");
                })
                .catch((error) => {
                    console.error(error);
                });
            /* 다음 사람이 토스할 목록을 보내기 위한 작업 끝*/
        };

        const faceRecognizeEmotions = function () {
            const video = document.getElementById("local-video-undefined");
            state.interval = setInterval(async () => {
                const detections = await faceapi
                    .detectAllFaces(
                        video,
                        new faceapi.TinyFaceDetectorOptions()
                    )
                    .withFaceLandmarks()
                    .withFaceExpressions();
                // console.log(detections);

                if (detections.length > 0) {
                    detections.forEach((element) => {
                        let status = "";
                        let valueStatus = 0.0;
                        for (const [key, value] of Object.entries(
                            element.expressions
                        )) {
                            if (value > valueStatus) {
                                status = key;
                                valueStatus = value;
                            }
                        }
                        statusPercent[status] += valueStatus;
                        cnt++;
                        statusAverage[status] = statusPercent[status] / cnt;
                        console.log(statusPercent);
                    });
                } 
            }, 1000);
        };

        const voiceTextStart = function () {
            if ("webkitSpeechRecognition" in window) {
                //Web speech API Function
                // var speechRecognizer = new webkitSpeechRecognition();
                state.speechRecognizer = new webkitSpeechRecognition();
                //continuous : you will catch mic only one time or not
                state.speechRecognizer.continuous = true;
                //interimResults : during capturing the mic you will send results or not
                state.speechRecognizer.interimResults = true;
                //lang : language (ko-KR : Korean, en-IN : englist)
                state.speechRecognizer.lang = "ko-KR";
                //start!
                state.speechRecognizer.start();

                let finalTranscripts = "";

                //if the voice catched onresult function will start
                state.speechRecognizer.onresult = function (event) {
                    // let interimTranscripts = "";
                    for (
                        let i = event.resultIndex;
                        i < event.results.length;
                        i++
                    ) {
                        let transcript = event.results[i][0].transcript;
                        transcript.replace("\n", "<br>");

                        //isFinal : if speech recognition is finished, isFinal = true
                        if (event.results[i].isFinal) {
                            finalTranscripts += transcript;
                        } else {
                            // interimTranscripts += transcript;
                        }
                    }

                    // console.log(finalTranscripts);
                    state.recordingText += finalTranscripts;
                };
                state.speechRecognizer.onerror = function () {};
            } else {
                //if browser don't support this function. this message will show in your web
                // voiceTextObject.innerHTML =
                //     "your browser is not supported. If google chrome. Please upgrade!";
            }
        };
        let statusAverage = {
            default: 0,
            neutral: 0,
            happy: 0,
            sad: 0,
            angry: 0,
            fearful: 0,
            disgusted: 0,
            surprised: 0,
        };

        const getEmothiontList = async () => {
            console.log("loading...");
            console.log(statusAverage);
            const requestOptions = {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    default: statusAverage["default"],
                    neutral: statusAverage["neutral"],
                    happy: statusAverage["happy"],
                    sad: statusAverage["sad"],
                    angry: statusAverage["angry"],
                    fearful: statusAverage["fearful"],
                    disgusted: statusAverage["disgusted"],
                    surprised: statusAverage["surprised"],
                }),
            };
            try {
                const response = await fetch(
                    `https://045d5080-b0f3-4dd5-9240-aee771955f6d.mock.pstmn.io/emotionList`,
                    requestOptions
                );
                const json = await response.json();
                console.log(json);
            } catch (error) {
                // alert("마지막 페이지 입니다")
                // $state.error();
            }
        };

        const recordingStop = async () => {
            /* 감정정보 저장 및 감정번호 받아오기 시작 */
            let myEmotions = statusPercent;
            myEmotions.user = {
                userId: store.state.userId, // 여기에는 자신의 userId가 들어와야 함.
                // userId: "testUser", // toss 테스트용 ID (주의! DB에 해당 유저 존재해야 함)
            };

            await axios
                .post("http://localhost:8080/api/emotions", myEmotions)
                .then(({ data: emotionsObject }) => {
                    // 감정정보 대입
                    console.log(emotionsObject.emotionsId);
                    myDiary.emotions.emotionsId = emotionsObject.emotionsId;
                });
            /* 감정정보 저장 및 감정번호 받아오기 끝 */
            state.speechRecognizer.stop();
            clearInterval(state.interval);
            
            // 제목 입력 창 띄우기
            emit("recordingStop");
            state.showTitleModal = !state.showTitleModal;
            // console.log(state.recordingText);
            // console.log("녹화중지 버튼 누름");
        };

        const saveDiary = function () {
            // 일기 저장 
            myDiary.content = state.recordingText;
            myDiary.diaryGroup.groupId = props.diaryGroupId;
            myDiary.title = state.diaryTitle;
            myDiary.videoLink = props.videoLink;

            // console.log("----저장시의 myDiary 데이터----");
            // console.log(myDiary);
            // console.log("-------------------------------");

            axios
                .post(`http://localhost:8080/api/diary`, myDiary)
                .then((response) => {
                    console.log(response);
                });
            // emit("recordingStop");
            state.showTitleModal = !state.showTitleModal;
            closeRecording();
        };

        Promise.all([
            faceapi.nets.tinyFaceDetector.loadFromUri("/models"),
            faceapi.nets.faceLandmark68Net.loadFromUri("/models"),
            faceapi.nets.faceRecognitionNet.loadFromUri("/models"),
            faceapi.nets.faceExpressionNet.loadFromUri("/models"),
        ]);
        return {
            state,
            closeRecording,
            recordingStart,
            recordingStop,
            voiceTextStart,
            faceRecognizeEmotions,
            getEmothiontList,
            saveDiary,
            tossUser,
        };
    },
};
</script>

<style scoped>
.recording-modal {
    width: 90vw;
    height: 85vh;
}

.modal-header {
    display: flex;
}

.modal-btn {
    margin-left: auto;
}

#session-header {
    margin-bottom: 20px;
}

#session-title {
    display: inline-block;
}

#buttonLeaveSession {
    float: right;
    margin-top: 20px;
}

#session img {
    width: 100%;
    height: auto;
    display: inline-block;
    object-fit: contain;
    vertical-align: baseline;
}

#session #video-container img {
    position: relative;
    float: left;
    width: 50%;
    cursor: pointer;
    object-fit: cover;
    height: 180px;
}

#video-container video {
    position: relative;
    float: left;
    width: 50%;
    cursor: pointer;
}

#video-container video + div {
    float: left;
    width: 50%;
    position: relative;
    margin-left: -50%;
}

#video-container p {
    display: inline-block;
    background: #f8f8f8;
    padding-left: 5px;
    padding-right: 5px;
    color: #777777;
    font-weight: bold;
    border-bottom-right-radius: 4px;
}

/* video {
    width: 100%;
    height: auto;
} */

#main-video p {
    position: absolute;
    display: inline-block;
    background: #f8f8f8;
    padding-left: 5px;
    padding-right: 5px;
    font-size: 22px;
    color: #777777;
    font-weight: bold;
    border-bottom-right-radius: 4px;
}

.videocenter {
    border-radius: 3rem;
    /* margin: auto; */
    text-align: center;
}

input.btn {
    font-weight: bold;
}

.btn {
    font-weight: bold !important;
}

.btn-success {
    background-color: #06d362 !important;
    border-color: #06d362;
}

.btn-success:hover {
    background-color: #1abd61 !important;
    border-color: #1abd61;
}

.diaryTitleModal {
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* #result {
  height: 200px;
  border: 1px solid #ccc;
  padding: 10px;
  box-shadow: 0 0 10px 0 #bbb;
  margin-bottom: 30px;
  font-size: 14px;
  line-height: 25px;
} */

.recording-container{
    display:flex;
    justify-content: space-around;
}

</style>
