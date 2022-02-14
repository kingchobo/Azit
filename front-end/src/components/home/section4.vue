<template>
<div class="layer">
  <div class="wrap">
   <div class="parent4" style="margin-top: 23%">
        <div class="child4" style=" font-family: 'Times New Roman', Times, serif;">
          <span style="color:#993123; font-size:60px;">T</span>ogether
        </div>
        <br>
      </div>
      <div class="parent4">
        <div class="child4">
          함께 작성해 보세요.
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
.parent4 {
    height: 6em; /* 애니메이션 높이 */
    overflow-y: hidden;
    display: block;
    
    
}

.parent4 .child4 {
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