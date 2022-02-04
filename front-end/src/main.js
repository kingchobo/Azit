import { createApp } from "vue"
import App from "./App.vue"
import { VuesticPlugin } from "vuestic-ui"
import 'vuestic-ui/dist/vuestic-ui.css'
import router from './router'
import store from './store'
import 'animate.css'
import 'fullpage-vue/src/fullpage.css'
import VueFullpage from 'fullpage-vue'

const app = createApp(App).use(store).use(router).use(VueFullpage)
app.use(VuesticPlugin)
app.mount("#app")
