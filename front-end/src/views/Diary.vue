<template>
  <div id="diary">
    <div class="container">
      <div class="row">
        <div>
          <FirstRow />
        </div>
      </div>
      <div class="row">
        <div> 
          <DiaryList />
        </div>
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
    DiaryList
  }
}
</script>

<style>

</style>