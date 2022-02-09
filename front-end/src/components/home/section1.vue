<template>
    <div class="first-section-bg">

      <va-alert center class="mb-4">
        <h1>당신의 오늘 하루는 어떠셨나요</h1>
        <Buttons
              class="write-diary"
              btn-text="일기작성" />    
      </va-alert>
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
.first-section-bg{
  background-image: url("../../assets/firstSection.jpg");
  width: auto;
  height: auto;
}

</style>
