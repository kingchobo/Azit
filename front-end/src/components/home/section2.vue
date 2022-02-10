<template>
<va-parallax
    target=".base-layout__content"
    :src="'https://i.postimg.cc/T245bxnV/back2.jpg'"
    :height="1000"
    class="s1">
  <h1>함께 오늘을 만들어봐요 </h1>
  <h1>함께 오늘을 만들어봐요 </h1>
</va-parallax>
  
<div class="section2">
      
 </div> 
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
}
</script>

<style>
/* .section2{
  background-image: url('~@/assets/back2.jpg');
  z-index: 100;
} */
.s1{
  z-index: -1;
}
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