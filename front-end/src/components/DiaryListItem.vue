<template>
  <va-card @click="onOpenDetail">
    <va-image
      src="https://picsum.photos/400/200"
      style="height: 200px;"
    />
    <va-card-title>Title</va-card-title>
    <va-card-content>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</va-card-content>
  </va-card>
  <DiaryDetail 
    :open="openDetail"
    @closeDetail="this.openDetail = !this.openDetail"/>
</template>

<script>
import axios from 'axios'
import DiaryDetail from '@/components/DiaryDetail.vue'

export default {
    name:'DiaryListItem',
    components: {
      DiaryDetail
    },
    data(){
      return{
        openDetail: false,
      };
    },
    methods:{
    onOpenDetail () {
      this.openDetail = !this.openDetail
      axios({
        method: 'get',
        url: 'http://localhost:8080/v1/diary/{diaryid}'
      }).catch( res => {
        console.log(res)
        // 받아와서 store에 저장 -> store에서 가져와서 디테일 페이지
      })
    }
  }
}
</script>

<style>

</style>