<template>
<div class="layer" style="font-family: 'Noto Sans KR', sans-serif;">

      <div class="parent" style="margin-top: 20%">
        <div class="child" style="font-weight: 700;">
          ANOTHER WORLD
        </div>
        <br>
      </div>
      <div class="parent" >
        <div class="child">
           우리들만의 또다른 세상
        </div>
        <br>
      </div>
   

      <!-- <div >
        
        <Buttons
          class="write-diary"
          btn-text="일기작성" 
          @click="onOpenRecording"/>    
      </div> -->

    <Recording
      :open="openRecording"
      @closeRecording="this.openRecording = !this.openRecording"
    />
 </div> 
</template>

<script>
import Recording from '@/components/Recording.vue'

export default {
  components: {

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
    height: 4em; /* 애니메이션 높이 */
    overflow-y: hidden;
    display: block;
    
    
    
}

 .parent .child {
    color: aliceblue;
    font-size: 50px;/* 애니메이션 높이 */
    font-weight: 400;
    
    line-height: 1;
    
    animation-name: grow;
    animation-duration: 1.5s;/* 애니메이션 시간 */
    float : left;
    margin-left: 12%;
    
}
/* 키프레임 애니메이션 */
@keyframes grow {
    from { transform: translateY(3em) }/* 애니메이션 높이 */
    to { transform: translateY(0) }
}
 

</style>
