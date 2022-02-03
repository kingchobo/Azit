<template>
  <div class="home">
    
    
  </div>
  <va-button @click="onOpenDetail">상세페이지 보기</va-button>
  <DiaryDetail 
    :open="openDetail"
    @closeDetail="this.openDetail = !this.openDetail"
  />
</template>

<script>
// @ is an alias to /src
import axios from 'axios'
import DiaryDetail from '@/components/DiaryDetail.vue'

export default {
  name: 'Home',
  components: {

    DiaryDetail
  },
  data () {
    return {
      openDetail: false,
    }
  },
  methods: {
    onOpenDetail () {
      this.openDetail = !this.openDetail
      axios({
        method: 'get',
        url: 'http://localhost:8080/v1/diary/{diaryid}'
      }).catch( res => {
        console.log(res)
        // 이걸 어떻게....
        // 받아와서 store에 저장 -> store에서 가져와서 디테일 페이지
      })
    },
    check(){
      console.log('확인')
    }
  }
}
</script>
