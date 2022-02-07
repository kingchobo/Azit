<template> 


    <div class="go-diary-container">
      <div class="left-btns">
        <!-- Left Buttons -->
        <!-- router 임의 설정, 나중에 바꿔서 해당 router로 push -->
        <Buttons
          btn-text="일기작성" />
        <Buttons
          class="write-with-diary"
          btn-text="함께쓰기" 
          @click=" this.$router.push({ name: 'Home' })" />
      </div>
    
      <div class="right-btns">
        <!-- Search -->
        <div class="search">
          <input
            type="text" 
            placeholder="내용을 입력해주세요." />
          <div class="material-icons">
            search
          </div>
        </div>
      
        <!-- Right Buttons -->
        <Buttons 
          class="search-filter"
          btn-text="필터" />
      </div>
    </div>

</template>

<script>
import Buttons from './Buttons.vue'
export default {
  components: {
    Buttons
  },
}
</script>

<style scoped>

.go-diary-container{
  display: flex;
  justify-content: space-between;
}

.left-btns {
  display: inline-flex;
}

.write-with-diary{
  margin-left: 20px;
}

.right-btns {
  display: flex;
}

.search-filter {
  margin-left: 20px;
}

.search {
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