import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Diary from "@/views/Diary.vue";
import About from "@/views/About.vue";

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

export default router
