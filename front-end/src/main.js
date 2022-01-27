import { createApp } from "vue"
import App from "./App.vue"
import { VuesticPlugin } from "vuestic-ui"
import 'vuestic-ui/dist/vuestic-ui.css'
import router from './router'
import store from './store'

const app = createApp(App).use(store).use(router)
app.use(VuesticPlugin)
app.mount("#app")
