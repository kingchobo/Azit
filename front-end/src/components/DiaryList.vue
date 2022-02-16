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
    <vue-typer
        class="display-3"
        :text="[
            '안녕하세요.',
            '김정훈의 포트폴리오입니다!!!',
            '방문 감사합니다!!!',
        ]"
        :repeat="Infinity"
        initial-action="typing"
        :pre-type-delay="100"
        :type-delay="200"
        :pre-erase-delay="1500"
        :erase-delay="250"
        erase-style="backspace"
        :erase-on-complete="false"
        caret-animation="blink"
    ></vue-typer>
    <!-- <div v-if="diarys.length"> -->
        <div class="row">
            <diary-list-item
                class="result"
                v-for="diary in diarys"
                :key="diary.diaryId"
                :diary="diary"
            />
            <InfiniteLoading :diarys="diarys" @infinite="load" />
        </div>
    <!-- </div>
    <div v-else>
        <h1 style="margin : 20%">아직 작성된 일기가 없습니다.</h1>
    </div> -->

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
import DiaryListItem from "@/components/DiaryListItem.vue";

export default {
    components: {
        DiaryListItem,
    },

    methods: {
        newdiary() {
            this.$router.push({ name: "Record" });
        },
    },
};
</script>
<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup
import { ref } from "vue";
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";
import { useStore } from "vuex";
const store = useStore();

let diarys = ref([]);
let page = 1;
// userid는 로그인 정보 이용해서 받아오기!! (수정 필요)
// let userid = 1;
const load = async ($state) => {
    console.log("loading...");
    //   console.log(userid);
    console.log(store.state.userId);
    try {
        const response = await fetch(
            `/api/diary/list?userId=${store.state.userId}&diaryPage=` + page
        );
        const json = await response.json();
        console.log(json);
        if (json.length < 10) {
            diarys.value.push(...json);
            // $state.complete();
        } else {
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
