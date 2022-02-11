<template>
<div>
  
      <div class="parent">
        <div class="child">
          당신의 오늘 하루는 어떠셨나요?
        </div>
      </div>
      <div >
        <Buttons
          class="write-diary"
          btn-text="일기작성" 
          @click="onOpenRecording"/>    
      </div>

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

<style scoped>


.left-btns .write-diary{
  float: left;
  margin-right: 20px;
}
.left-btns .write-with-diary{
  float: left;
  }
#bg {
  position: fixed; 
  top: 0; 
  left: 0; 
    
  /* Preserve aspet ratio */
  min-width: 100%;
  height: 950px;
  z-index: -1;
}

.section1-text{
  z-index: 1;
}

.parent {
    height: 3em; /* 애니메이션 높이 */
    overflow-y: hidden;
    display: block;
}
.parent .child {
    font-size: 3em;/* 애니메이션 높이 */
    font-weight: bold;
    line-height: 1;
    animation-name: grow;
    animation-duration: 1s;/* 애니메이션 시간 */
}
/* 키프레임 애니메이션 */
@keyframes grow {
    from { transform: translateY(3em) }/* 애니메이션 높이 */
    to { transform: translateY(0) }
}
 

</style>
