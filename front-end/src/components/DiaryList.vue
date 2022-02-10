<template>
  <div>
    <div class="row">ㅇㅇㅇ
      <div class="flex md4 lg3">
        <diary-list-item/>
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


export default {
  components: {
    DiaryListItem
  },

  data(){
    return{
    };
  },
  methods:{
    newdiary(){
      this.$router.push({ name : 'Record'})
    }
  }
};

</script>

<style>

</style>