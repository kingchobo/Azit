<template>
  <div>
    <button
      type="button"
      class="btn">
      {{ btnText }}
    </button>
  </div>
</template>

<script>
export default {
  props: {
    btnText: {
      type: String,
      default: ''
    }
  }
}
</script>

<style scoped>
.btn {
  width: 100px;
  padding: 10px;
  border: 2px solid #5959be;
  color: #3b3ba0;
  font-weight: 700;
  font-size: 15px;
  text-align: center;
  cursor: pointer;
  transition: .4s;
  margin: 20px 0;
  background-color: #6565ca;
  color: #fff;
  display: block;
  box-sizing: border-box;
}
.btn:hover {
  background-color: #fff;
  color: #37379c;
}
</style>