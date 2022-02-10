<template>
  <!-- <img src="../../assets/firstSection.jpg" id="second-bg" alt=""> -->
  <h1>함께 오늘을 만들어봐요</h1>

</template>

<script>
// import Buttons from '@/components/Buttons.vue'
export default {
  components: {
    // Buttons
  },data () {
    return {
      imageSrc: '~@/assets/back1.jpg',
    }
  },
  data () {
    return {
      
    }
  }
}
</script>

<style>
#second-bg {
  position: fixed; 
  /* margin-top: 2000; */
  top: 2000; 
  left: 0; 
    
  /* Preserve aspet ratio */
  min-width: 100%;
  height: 700px;
  z-index: -1;
}

</style>