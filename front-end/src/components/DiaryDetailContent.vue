<template>
  
  <div class="video-content"></div>
  
</template>

<script>

export default {
    name: "DiaryDetailContent",

    setup(props, {emit}) {
      const moveContent = function() {
        emit('moveContent')
      }

      return {moveContent}
    }
}
</script>

<style scoped>
.video-content {
  display: block;
  width: 25vw;
  height: 50vh;
  background: lightgray;
}


</style>