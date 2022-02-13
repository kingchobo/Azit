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
                <!-- session 헤더 및 leaveSession 버튼 -->
                <!-- <div id="session-header">
          <input
            class="btn btn-large btn-danger"
            type="button"
            id="buttonLeaveSession"
            @click="leaveSession"
            value="Leave session"
          />
        </div> -->
        <div class="row justify--space-around">
          <!-- <div class="flex md6 lg4">
            <va-card stripe stripe-color="success">
              <va-card-title> 자기 화면</va-card-title>
              <hr />
              <div id="main-video" class="flex md10 videocenter">
                <user-video :stream-manager="mainStreamManager" />
              </div>
            </va-card>
          </div> -->
          <div class="flex md6 lg12 justify--space-center">
          
              <div id="video-container" class="flex md videocenter4">
                <user-video :stream-manager="publisher" />
                <!-- @click.native="updateMainVideoStreamManager(publisher)" -->
                <user-video
                  v-for="sub in subscribers"
                  :key="sub.stream.connection.connectionId"
                  :stream-manager="sub"
                />
              </div>
          </div>
          <!-- @click.native="updateMainVideoStreamManager(sub)" -->
        </div>
      </div>
      <div class="row justify--center">
        <Buttons class="mx-2" btn-text="녹화 시작" @click="recordingStart" />
        <Buttons
          class="mx-2"
          btn-text="toss"        
        />
        <Buttons
          class="mx-2"
          btn-text="녹화 중지"
          @click="recordingStop(), getEmothiontList()"          
        />
        <!-- <div id="result"></div> -->

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


axios.defaults.headers.post["Content-Type"] = "application/json";

export default {
    components: {
        UserVideo,
        Buttons
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
        }
    },
    setup(props, { emit }) {
        const state = reactive({
            recordingVisible: computed(() => props.open),
            interval: null,
            speechRecognizer: Object,
            recordingText: ''
        });

        const closeRecording = function () {
            emit("closeRecording");
        };
        let cnt = 0;
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

        const recordingStart = function () {
            emit("recordingStart");
            faceRecognizeEmotions();
            voiceTextStart();
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
                console.log(detections);
                // const resizedDetections = faceapi.resizeResults(detections, displaySize)
                // faceapi.draw.drawDetections(canvas, resizedDetections)

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
                } else {
                    console.log(0);
                }
            }, 1000);
        };
        const voiceTextStart = function () {
            // const voiceTextObject = document.getElementById("result");
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
                    //insert into HTML
                    // voiceTextObject.innerHTML =
                    //     finalTranscripts +
                    //     '<span style="color:#999">' +
                    //     interimTranscripts +
                    //     "</span>";
                    // console.log(finalTranscripts);
                    state.recordingText = finalTranscripts
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
    // const recordingStart = function () {
    //   emit("recordingStart");
    //   const video = document.getElementById("local-video-undefined");
    //   state.interval = setInterval(async () => {
    //     const detections = await faceapi
    //       .detectAllFaces(video, new faceapi.TinyFaceDetectorOptions())
    //       .withFaceLandmarks()
    //       .withFaceExpressions();
    //     console.log(detections);
    //     // const resizedDetections = faceapi.resizeResults(detections, displaySize)
    //     // faceapi.draw.drawDetections(canvas, resizedDetections)

    //     if (detections.length > 0) {
    //       detections.forEach((element) => {
    //         let status = "";
    //         let valueStatus = 0.0;
    //         for (const [key, value] of Object.entries(element.expressions)) {
    //           if (value > valueStatus) {
    //             status = key;
    //             valueStatus = value;
    //           }
    //         }
    //         statusPercent[status] += valueStatus;
    //         cnt++;
    //         statusAverage[status] = statusPercent[status] / cnt;
    //         console.log(statusPercent);
    //         console.log(cnt);
    //         console.log(statusAverage);
    //       });
    //     } else {
    //       console.log(0);
    //     }
    //   }, 1000);
    // };

        const recordingStop = function () {
            // const params = {               
            //     'user_id': '',
            //     'video_link':'',
            //     'emotions_id':'',
            //     'content': state.recordingText,
            //     'thumbnail':''
            // }
            // axios.post(`https://api/diary`, params)
            //     .then((response) => {
            //         console.log(response)
            // });

            emit("recordingStop");
            console.log(state.recordingText)
            state.speechRecognizer.stop();
            clearInterval(state.interval);
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

video {
    width: 100%;
    height: auto;
}

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
  margin: auto;
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

/* #result {
  height: 200px;
  border: 1px solid #ccc;
  padding: 10px;
  box-shadow: 0 0 10px 0 #bbb;
  margin-bottom: 30px;
  font-size: 14px;
  line-height: 25px;
} */
</style>
