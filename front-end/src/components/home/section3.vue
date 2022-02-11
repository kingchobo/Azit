<template>
<div>
  <div class="wrap">
    <div class="parent"><div class="child">시간을 기록하고 추억을 담아보세요</div></div>
    <div class="parent">
      <div class="child">
        하루 하루 추억을 담기 위해 일기를 기록합니다. 
        하지만 글로 쓰여진 일기장 속에서 그날의 모습, 그날의 분위기까지 기억하기란 쉽지 않습니다. 아지트는 시간을 기록하고 공간을 담을 수 있는 일기장 입니다.
        </div>
      </div>
    <div class="parent"><div class="child">하지만 글로 쓰여진 일기장 속에서 그날의 모습, 그날의 분위기까지 기억하기란 쉽지 않습니다. 아지트는 시간을 기록하고 공간을 담을 수 있는 일기장 입니다.</div></div>
  </div>
      <div center class="mb-4">
         <Buttons
              class="write-diary"
              btn-text="일기작성" />    
      </div>
        
 </div> 
</template>

<script>
import Buttons from '@/components/Buttons.vue'
export default {
  components: {
    Buttons
  },
}
</script>

<style>
.parent {
    height: 1em; /* 애니메이션 높이 */
    overflow-y: hidden;
    display: block;
}
.parent .child {
    font-size: 1em;/* 애니메이션 높이 */
    font-weight: bold;
    line-height: 1;
    animation-name: grow;
    animation-duration: 1s;/* 애니메이션 시간 */
}
/* 키프레임 애니메이션 */
@keyframes grow {
    from { transform: translateY(1em) }/* 애니메이션 높이 */
    to { transform: translateY(0) }
}
 
</style>