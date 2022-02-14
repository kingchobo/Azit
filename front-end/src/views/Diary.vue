<template >

<div class="whitebox" >

  <DiaryNavbars/>
</div><br><br><br>
  <div id="diary">
    <div class="diary-container">
      <div>
        <FirstRow />
      </div>
      <div> 
        <DiaryList />
      </div>
    </div>
  </div>
  
</template>

<script>
import FirstRow from '@/components/FirstRow.vue'
import DiaryList from '@/components/DiaryList.vue'
import DiaryNavbars from '@/components/DiaryNavbars.vue'
export default {
  components: {
    FirstRow,
    DiaryList,
DiaryNavbars
  },
  data () {
    return {
      
    }
  },
  beforeUnmount() {
         this.$router.go();
  },
}
</script>

<style>
.whitebox{
  color: rgb(0, 0, 0);
  position:fixed;
  width: 100%;
  height: 80px;
  background-color:rgb(255, 255, 255);
  /* background: url('https://cdn.pixabay.com/photo/2017/02/15/11/05/texture-2068283_960_720.jpg' ); */
  z-index: 1;
}
.diary-container{
  margin: 3rem;
  /* border: 2px solid; */
}

</style>