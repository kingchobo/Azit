<template>
  <div>
    <div class="row">
      <div class="flex md4 lg3">
        <!-- v-for="(diary, index) in diarys" :key="index" v-bind ="diary" 추가 하기-->
        <DiaryListItem/>
      </div>
    </div>
    <DiaryListRow />
    
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