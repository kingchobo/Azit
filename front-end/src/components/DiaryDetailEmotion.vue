<template>
  <div class="emotion-content">
    <span class="text-white uppercase">{{ name }}</span>
    <div class="text-xs leading-none py-1 text-center text-white rounded-lg"
      :style="{ width: (base*2)+'px', background: color}">{{ base }}</div>
  </div>
</template>


<script>

export default {
    name: 'DiaryDetailEmotion',
    data(){
      return {
        name: '',
        color: 'white',
        base: ''
      };
    }
}
</script>

<style>
.emotion-content {
  display: block;
  width: 25vw;
  height: 50vh;
}
</style>
