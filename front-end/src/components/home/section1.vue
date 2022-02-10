<template>
   <!-- <img src="../../assets/firstSection.jpg" id="bg" alt=""> -->
   <p>당신의 오늘 하루는 어떠셨나요</p>
    <Buttons />
</template>

<script>
import Buttons from '@/components/Buttons.vue'
export default {
  components: {
    Buttons
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
