<template>
  <div>
    <div class="row">
      <div class="flex md4 lg3">
        <diary-list-item
         v-for="diary in diarys"
         :key="diary.title"
         :diary="diary"
        />
      </div>

      <!-- <div class="flex md4 lg3" v-if="diarys.length"> 
        <diary-list-item
        v-for="(diary, index) in diarys"
        :key="index"
        v-bind="diary">
        </diary-list-item>
      </div>
      <div v-else> 
        게시글이 없습니다.
      </div> -->
    </div>
  </div>
</template>

<script>
import DiaryListItem from '@/components/DiaryListItem.vue'
import axios from 'axios'

export default {
  components: {
    DiaryListItem
  },

  data(){
    return{
      diarys: []
    };
  },
  methods:{
    newdiary(){
      this.$router.push({ name : 'Record'})
    }
  },
  created() {
    //url "/api/diary/{userid}" 
    axios.get('https://d373f615-141e-4add-8fb7-910b49246039.mock.pstmn.io/diarylist')
    .then(response => {
      this.diarys = response.data
      // console.log(response.data)
    })
  }

};

</script>

<style>

</style>