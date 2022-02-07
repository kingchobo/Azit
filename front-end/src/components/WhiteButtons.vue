<template>
  <div>
    <button
      class="white-btn">
      {{ whiteBtnText }}
    </button>
  </div>
</template>

<script>
export default {
  props: {
    whiteBtnText: {
      type: String,
      default: ''
    }
  }
}
</script>

<style scoped>
.white-btn {
  width: 100px;
  padding: 10px;
  border-radius: 5px;
  border: 2px solid #5959be;
  color: #3b3ba0;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  transition: .4s;
  margin: 20px 0;
  background-color: #fff;
  color: #6565ca;
  display: block;
  box-sizing: border-box;
}
.white-btn:hover {
  color: #fff;
  background-color: #6565ca;
}
</style>