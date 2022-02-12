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
        <div id="main-video" class="flex md4">
          <user-video :stream-manager="mainStreamManager" />
        </div>
        <div id="video-container" class="flex md4">
          <user-video :stream-manager="publisher" />
          <!-- @click.native="updateMainVideoStreamManager(publisher)" -->
          <user-video
            v-for="sub in subscribers"
            :key="sub.stream.connection.connectionId"
            :stream-manager="sub"
          />
          <!-- @click.native="updateMainVideoStreamManager(sub)" -->
        </div>
      </div>
      <Buttons class="mx-2" btn-text="녹화 시작" @click="recordingStart" />
      <Buttons class="mx-2" btn-text="녹화 중지" @click="recordingStop" />
    </div>
  </va-modal>
</template>

<script>
import { computed, reactive } from "vue";
import UserVideo from "./UserVideo.vue";
import Buttons from "./Buttons.vue";
import axios from "axios";
import * as faceapi from "face-api.js";

// import WhiteButtons from "./WhiteButtons.vue";

axios.defaults.headers.post["Content-Type"] = "application/json";

export default {
  components: {
    UserVideo,
    Buttons,
    // WhiteButtons,
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
    setup(props, { emit }) {
      const state = reactive({
        recordingVisible: computed(() => props.open),
      });

      const closeRecording = function () {
        emit("closeRecording");
      };
      return { state, closeRecording };
    },
  },
  data() {
    return {

    };
  },

  setup(props, { emit }) {
    const state = reactive({
      recordingVisible: computed(() => props.open),
      interval: null
    });

    const closeRecording = function () {
      emit("closeRecording");
    };

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
      const video = document.getElementById("local-video-undefined");
      state.interval = setInterval(async () => {
        const detections = await faceapi
          .detectAllFaces(video, new faceapi.TinyFaceDetectorOptions())
          .withFaceLandmarks()
          .withFaceExpressions();
        console.log(detections);
        // const resizedDetections = faceapi.resizeResults(detections, displaySize)
        // faceapi.draw.drawDetections(canvas, resizedDetections)

        if (detections.length > 0) {
          detections.forEach((element) => {
            let status = "";
            let valueStatus = 0.0;

            for (const [key, value] of Object.entries(element.expressions)) {
              if (value > valueStatus) {
                status = key;
                valueStatus = value;
              }
            }
            statusPercent[status] += valueStatus;
            console.log(statusPercent);
          });
        } else {
          console.log(0);
        }
      }, 1000);
    };

    const recordingStop = function () {
      emit("recordingStop");
      clearInterval(state.interval);
    };

    Promise.all([
      faceapi.nets.tinyFaceDetector.loadFromUri("/models"),
      faceapi.nets.faceLandmark68Net.loadFromUri("/models"),
      faceapi.nets.faceRecognitionNet.loadFromUri("/models"),
      faceapi.nets.faceExpressionNet.loadFromUri("/models"),
    ]);
    return { state, closeRecording, recordingStart, recordingStop };
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
</style>
