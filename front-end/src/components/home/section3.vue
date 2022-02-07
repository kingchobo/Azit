<template>
<div >
      <h1>시간을 기록하고 추억을 담아보세요</h1>
      <h5>하루 하루 추억을 담기 위해 일기를 기록합니다. 
        하지만 글로 쓰여진 일기장 속에서 그날의 모습, 그날의 분위기까지 기억하기란 쉽지 않습니다. 아지트는 시간을 기록하고 공간을 담을 수 있는 일기장 입니다.</h5>
      <div center class="mb-4">
         <Buttons
              class="write-diary"
              btn-text="일기작성" />    
      </div>
        
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