<template>
<div class="layer">
  <div class="wrap">
   <div class="parent3" style="margin-top: 23%">
        <div class="child3" style=" font-family: Wide">
          <span style="color:#9999FF; font-size:60px;"></span>Impress 
        </div>
        <br>
      </div>
      <div class="parent3">
        <div class="child3">
           잊지 못할 우리만의 놀이터
        </div>
        <br>
      </div>
  </div>
      <!-- <div center class="mb-4">
         <Buttons
              class="write-diary"
              btn-text="일기작성" />    
      </div> -->
        
 </div> 
</template>

<script>
export default {
  components: {
  },
}
</script>

<style>
.parent3 {
    height: 6em; /* 애니메이션 높이 */
    overflow-y: hidden;
    display: block;
    
    
}

.parent3 .child3 {
    color: aliceblue;
    font-size: 50px;/* 애니메이션 높이 */
    font-weight: bold;
    line-height: 1;
    animation-delay: 3.5s;
    animation-name: grow;
    animation-duration: 1.5s;/* 애니메이션 시간 */
    float : left;
    margin-left: 50%;
    
}
/* 키프레임 애니메이션 */
@keyframes grow {
    from { transform: translateY(1em) }/* 애니메이션 높이 */
    to { transform: translateY(0) }
}
 
</style>