<template>
  <div class="video-content">
    dd
  </div>
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
  background: rgb(255, 251, 251);
  font-size: 10px;
}


</style>