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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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