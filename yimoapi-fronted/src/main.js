import { createApp } from 'vue'
import ViewUIPlus from 'view-ui-plus'
import App from './App.vue'
import router from './router'
import store from './store'
import './styles/index.less'
import http from "./plugins/axios";

import { PrismEditor } from 'vue-prism-editor';
import 'vue-prism-editor/dist/prismeditor.min.css'; // import the styles
import piniaPersist from 'pinia-plugin-persist'
import pinia from "./store/piniaEntity";
// import './mock'


const app = createApp(App)
pinia.use(piniaPersist)
app.config.globalProperties.$http = http
app.component('PrismEditor',PrismEditor)

app.use(router)
  .use(store)
  .use(ViewUIPlus)
  .use(pinia)
  .mount('#app')
