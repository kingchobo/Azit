import { createApp } from "vue"
import App from "./App.vue"
import { VuesticPlugin } from "vuestic-ui"
// import BootstrapVue3 from 'bootstrap-vue-3'
import 'vuestic-ui/dist/vuestic-ui.css'
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import router from './router'
import store from './store/store'
import 'animate.css'
import 'fullpage-vue/src/fullpage.css'
import VueFullpage from 'fullpage-vue'
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css"; //required if you're not going to override default slots


const app = createApp(App).use(store).use(router).use(VueFullpage).component("infinite-loading", InfiniteLoading);
app.use(VuesticPlugin)
app.mount("#app")



