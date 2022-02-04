<template> 


    <div class="go-diary-container">
      <div class="left-btns">
        <!-- Left Buttons -->
        <!-- router 임의 설정, 나중에 바꿔서 해당 router로 push -->
        <Buttons
          btn-text="일기작성" 
          @click="onOpenRecording"
          />
        <Buttons
          class="write-with-diary"
          btn-text="함께쓰기" 
          @click="showWithModal = !showWithModal" />
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
      <Recording
        :open="openRecording"
        @closeRecording="this.openRecording = !this.openRecording"
        />
      <va-modal 
        v-model="showWithModal" 
        title="추억을 저장 해보세요"
        hide-default-actions
      >
        <div class='group-btns'>
          <button class="make-group-btn mx-2">방 생성</button>
          <Buttons class="mx-2" btn-text="방 검색"/>
        </div>
      </va-modal>
    </div>

</template>

<script>
import Buttons from './Buttons.vue'
import Recording from './Recording.vue'

export default {
  components: {
    Buttons,
    Recording
  },
  data() {
    return {
      openRecording: false,
      showWithModal: false,
    }
  },
  methods: {
    onOpenRecording () {
      this.openRecording = !this.openRecording
    }
  }
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

.right-btns{
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

.make-group-btn {
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

.make-group-btn:hover {
  color: #fff;
  background-color: #6565ca;
}

.group-btns {
  display: flex;
}

</style>