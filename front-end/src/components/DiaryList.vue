<template>
  <!-- <div class="result" v-for="comment in comments" :key="comment.id">
    <div>{{ comment.email }}</div>
    <div>{{ comment.id }}</div>
  </div>
  <InfiniteLoading :comments="comments" @infinite="load" />
  <div> -->

<!-- <div class="result" v-for="comment in diarys" :key="comment.title">
    <div>{{ comment.title }}</div>
    <div>{{ comment.create_date }}</div>
  </div>
  <InfiniteLoading :comments="diarys" @infinite="load" />
  <div> -->


    <div class="row">
      <diary-list-item class="result"
        v-for="diary in diarys"
        :key="diary.diary_id"
        :diary="diary"
      />
      <InfiniteLoading :diarys="diarys" @infinite="load" />

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
    <!-- </div> -->
</template>

<script>
import DiaryListItem from '@/components/DiaryListItem.vue'

export default {
  components: {
    DiaryListItem
  },

  methods:{
    newdiary(){
      this.$router.push({ name : 'Record'})
    }
  },
};

</script>
<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup
  import { ref } from "vue";
  import InfiniteLoading from "v3-infinite-loading";
  import "v3-infinite-loading/lib/style.css";

  let diarys = ref([]);
  let page = 1;
  // userid는 로그인 정보 이용해서 받아오기!! (수정 필요)
  let userid = 1;
  const load = async $state => {
    console.log("loading...");
    console.log(userid)
    try {
      const response = await fetch(
        `https://eab5b3d9-43de-4dee-bee6-77ceb04377eb.mock.pstmn.io/diarylist/${userid}/` + page
      );
      const json = await response.json();
      console.log(json)
      if (json.length < 10
      ) $state.complete();
      else {
        diarys.value.push(...json);
        $state.loaded();
      }
      page++;
    } catch (error) {
      // alert("마지막 페이지 입니다")
      // $state.error();
    }
  };
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    /* margin-top: 60px; */
  }

  .result {
    display: flex;
    flex-direction: column;
    gap: 5px;
    font-weight: 300;
    width: 400px;
    padding: 10px;
    text-align: center;
    margin: 0 auto 10px auto;
    background: #eceef0;
    border-radius: 10px;
  }
</style>