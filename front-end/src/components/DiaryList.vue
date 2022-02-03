<template>
  <div>
    <div class="row row-cols-3 row-cols-lg-5 g-4 g-lg-4">
      <!-- v-for="(diary, index) in diarys" :key="index" v-bind ="diary" 추가 하기-->

      <div class="col"> 
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div>
      <div class="col">
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div>
      <div class="col">
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div>
      <div class="col">
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div>
      <div class="col">
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div> 
      <div class="col">
        <div class="p-3 border bg-light">
          Row column
        </div>
      </div>
    </div>
    <DiaryListRow />
  </div>
</template>

<script>

export default {
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