import { createApp } from "vue"
import App from "./App.vue"
import { VuesticPlugin } from "vuestic-ui"
// import BootstrapVue3 from 'bootstrap-vue-3'
import 'vuestic-ui/dist/vuestic-ui.css'
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
import router from './router'
import store from './store'

const app = createApp(App).use(store).use(router)
// app.use(BootstrapVue3)
app.use(VuesticPlugin)
app.mount("#app")