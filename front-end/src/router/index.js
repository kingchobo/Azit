import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Diary from "@/views/Diary.vue";
import About from "@/views/About.vue";
import store from "@/store/store";


const routes = [

  {
    path: '/',
    name: 'Home',
    component: Home
  },
 
  {
    path: "/diary",
    name: "Diary",
    component: Diary,
    meta: {authRequired: false}
  },
  {
    path: "/about",
    name: "About",
    component: About,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach(function (to, from, next) {
  console.log("라우터")
  console.log(to)
  // to: 이동할 url에 해당하는 라우팅 객체
  if (to.fullPath == '/diary' && store.state.userId =='') {
    // 이동할 페이지에 인증 정보가 필요하면 경고 창을 띄우고 페이지 전환은 하지 않음
    alert('로그인이 필요합니다');
    next("/")
  } else {
    next(); // 페이지 전환
  }
});
export default router
