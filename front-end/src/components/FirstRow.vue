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

      <!-- 일기 작성 modal -->
      <Recording
        :open="openRecording"
        @closeRecording="this.openRecording = !this.openRecording"
        />

      <!-- 함께 쓰기 modal -->
      <va-modal 
        v-model="showWithModal" 
        hide-default-actions
      >
        <b>추억을 저장 해보세요</b>
        <div class='group-btns'>
          <WhiteButtons class="mx-2" white-btn-text="방생성"/>
          <Buttons class="mx-2" btn-text="방 검색" @click="MoveSearchModal"/>
        </div>
      </va-modal>
      <!-- 방 생성 modal -->
      <va-modal
        v-model="showSearchModal" 
        hide-default-actions
      >
        <b>방에 참여 하시겠습니까?</b>
        <div class="search">
          <input
            type="text" 
            placeholder="내용을 입력해주세요." />
          <div class="material-icons">
            search
          </div>
        </div>
        <div class='group-btns'>
          <WhiteButtons class="mx-2" white-btn-text="취소" @click="CloseSearchModal"/>
          <Buttons class="mx-2" btn-text="참여하기"/>
        </div>
      </va-modal>
    </div>

</template>

<script>
import Buttons from './Buttons.vue'
import WhiteButtons from './WhiteButtons.vue'
import Recording from './Recording.vue'

export default {
  components: {
    Buttons,
    WhiteButtons,
    Recording
  },
  data() {
    return {
      openRecording: false,
      showWithModal: false,
      showSearchModal: false,
    }
  },
  methods: {
    onOpenRecording () {
      this.openRecording = !this.openRecording
    },
    MoveSearchModal () {
      this.showSearchModal = !this.showSearchModal
      this.showWithModal = !this.showWithModal
    },
    CloseSearchModal () {
      this.showSearchModal = !this.showSearchModal
      console.log(this.showSearchModal)
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

.group-btns {
  display: flex;
  margin-top: 1.5rem;
}

</style>