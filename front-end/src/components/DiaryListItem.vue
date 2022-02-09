<template>
  <va-card @click="onOpenDetail">
    <va-image
      :src=diary.thumbnail
      style="height: 200px;"
    />
    
    <!-- <va-image
      src="https://picsum.photos/400/200"
      style="height: 200px;"
    /> -->
    <!-- <va-card-title>{{diary.title}}</va-card-title> -->
    <va-card-content>{{diary.title}}</va-card-content>
    <va-card-content>{{diary.create_date}}</va-card-content>
  </va-card>
  <DiaryDetail 
    :open="openDetail"
    :diaryContent="diaryContent"
    @closeDetail="this.openDetail = !this.openDetail"/>
</template>

<script>
import DiaryDetail from '@/components/DiaryDetail.vue'
import axios from 'axios'

export default {
    name:'DiaryListItem',
    props: {
      diary: {
        type: Object,
      }
    },
    components: {
      DiaryDetail
    },
    data(){
      return{
        openDetail: false,
        diaryContent: []
      };
    },
    methods:{
      onOpenDetail () {
        this.openDetail = !this.openDetail
        console.log(this.diary)
        // url "/api/diary/{diaryid}""
        axios.get('https://d373f615-141e-4add-8fb7-910b49246039.mock.pstmn.io/diarydetail')
        .then(response => {
          this.diaryContent = response.data
        })
    }
  }
}
</script>

<style>

</style>