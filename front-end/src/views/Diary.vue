<template>
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

export default {
  components: {
    FirstRow,
    DiaryList,

  },
  data () {
    return {
      
    }
  },
  beforeUnmount() {
    // if(window.location.pathname == "/"){
         this.$router.go();
    // }
  },
}
</script>

<style>

.diary-container{
  margin: 3rem;
}

</style>