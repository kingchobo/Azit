<template>
<div class="whitebox" >
  <DiaryNavbars/>
</div><br>
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
import DiaryNavbars from '@/components/Navbars.vue'
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
  color: rgb(255, 255, 255);
  position:fixed;
  width: 100%;
  height: 80px;
  background-color:rgb(0, 0, 0,0.3);
  z-index: 1;
}
.diary-container{
  margin: 3rem;
}

</style>