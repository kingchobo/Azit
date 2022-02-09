<template>
<div>
      <va-alert center class="mb-4">
        <h1>당신의 오늘 하루는 어떠셨나요</h1>
        <Buttons
              class="write-diary"
              btn-text="일기작성" 
              @click="onOpenRecording"/>    
      </va-alert>

    <Recording
      :open="openRecording"
      @closeRecording="this.openRecording = !this.openRecording"
    />
 </div> 
</template>

<script>
import Buttons from '@/components/Buttons.vue'
import Recording from '@/components/Recording.vue'

export default {
  components: {
    Buttons,
    Recording
  },
  data() {
    return {
      openRecording: false,
    }
  },
  methods:{
  onOpenRecording () {
      this.openRecording = !this.openRecording
    },
}
}
</script>

<style>

.left-btns .write-diary{
  float: left;
  margin-right: 20px;
}
.left-btns .write-with-diary{
  float: left;
}

.right-btn {
  float: right;
  margin-left: 20px;
}

.search {
  float: right;
  position: relative;
  height: 34px;
  vertical-align: middle;
  top: 20px;
}

.search input {
  width: 200px;
  height: inherit;
  padding: 4px 10px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 5px;
  outline: none;
  background-color: #fff;
  color: #777;
  font-size: 12px;
}

.search input:focus {
  width: 200px;
  border-color: #000080;
}

.search .material-icons {
  height: 24px;
  position: absolute;
  top: 0;
  bottom: 0;
  right: 5px;
  margin: auto;
  cursor: pointer;
}

.search.focused .material-icons {
  opacity: 0;
}

</style>