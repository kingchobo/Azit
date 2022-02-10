<template>
<div>
      <va-alert center class="mb-4">
        <h1>당신의 오늘 하루는 어떠셨나요</h1>
        <Buttons
              class="write-diary"
              btn-text="일기작성" 
              @click="onOpenRecording"/>    
      </va-alert>

    <Recording
      :open="openRecording"
      @closeRecording="this.openRecording = !this.openRecording"
    />
 </div> 
</template>

<script>
import Buttons from '@/components/Buttons.vue'
import Recording from '@/components/Recording.vue'

export default {
  components: {
    Buttons,
    Recording
  },
  data() {
    return {
      openRecording: false,
    }
  },
  methods:{
  onOpenRecording () {
      this.openRecording = !this.openRecording
    },
}
}
</script>

<style>
#bg {
  position: fixed; 
  top: 0; 
  left: 0; 
    
  /* Preserve aspet ratio */
  min-width: 100%;
  height: 950px;
  z-index: -1;
}

</style>
