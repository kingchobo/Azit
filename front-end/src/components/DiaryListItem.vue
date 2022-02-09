<template>
  <div class="flex md4">
    <va-card @click="onOpenDetail" class="item" style="margin: 0.75rem;">
      <va-image
        :src=diary.thumbnail
        style="height: 200px;"/>
      
      <!-- <va-image
        src="https://picsum.photos/400/200"
        style="height: 200px;"
      /> -->
      <!-- <va-card-title>{{diary.title}}</va-card-title> -->
      <va-card-content>{{diary.title}}</va-card-content>
      <va-card-content>{{diary.create_date}}</va-card-content>
    </va-card>
  </div>
  <DiaryDetail 
    :open="openDetail"
    @closeDetail="this.openDetail = !this.openDetail"/>
</template>

<script>
import DiaryDetail from '@/components/DiaryDetail.vue'

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
        openDetail: false
      };
    },
    methods:{
      onOpenDetail () {
        this.openDetail = !this.openDetail
        console.log(this.diary)
    }
  }
}
</script>

<style>

</style>