<template>
  <div class="emotion-content">
    <div class="emotion-content-text my-1 text--bold">
       일기 감정 분석결과
    </div>
    <div class="emotion-content-bar">
      <div class="my-1 text--bold muted">기쁨</div>
      <va-progress-bar
        :model-value="80"
        color="danger"
       />
      <br />
      <div class="my-1 text--bold muted">중립</div>
      <va-progress-bar
        :model-value="10"
        color="success"
      />
      <br />
   
  
      <div class="my-1 text--bold muted">두려움</div>
      <va-progress-bar
        :model-value="10"
        color="#BE81F7"
      />
      <br />
  
      <div class="my-1 text--bold muted">슬픔</div>
      <va-progress-bar
       :model-value="5"
        color="warning"
      />
      <br />
  
      <div class="my-1 text--bold muted">놀람</div>
      <va-progress-bar
        :model-value="5"
       color="#1f00ff" 
      />
      <br />
  
      <div class="my-1 text--bold muted">혐오</div>
      <va-progress-bar
       :model-value="5"
        color="#F7FE2E"
      />
      <br />
  
      <div class="my-1 text--bold muted">화남</div>
      <va-progress-bar
       :model-value="5"
        color="#000058"
      />
    </div>
  </div>
</template>


<script>

export default {
    name: 'DiaryDetailEmotion'
    
}
</script>

<style scoped>
.emotion-content {
  display: block;
  width: 25vw;
  height: 50vh;
  background: white(0, 0, 0);
}
.emotion-content-text{
  font-size: 23px;
  padding-left: 20px;
  padding-top: 25px;
  background: black(0, 0, 0);
}
.emotion-content-bar{
  font-size: 13px;
  padding-top: 20px;
  padding: 20px;
  background: black(0, 0, 0);
}

</style>
