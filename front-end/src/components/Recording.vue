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
        <user-video :stream-manager="publisher" />
      </div>
    </div>
  </va-modal>
</template>

<script>
import { computed, reactive } from "vue";
import UserVideo from "./UserVideo.vue";

export default {
  name: "Recording",
  props: {
    open: {
      type: Boolean,
      default: false,
    },
    publisher: {
        type: Object,
    },
  },
  components: {
    UserVideo
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
</style>