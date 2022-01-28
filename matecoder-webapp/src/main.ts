import { createApp } from 'vue';
import antd from 'ant-design-vue';
//todo  后面使用babel-plugin-import 按需引入css
import 'ant-design-vue/dist/antd.css';
import App from './App.vue';

//import { Initializer } from './bootstrap';
import router from './router/index';
const app = createApp(App);
//阻止显示生产模式的消息
//app.config.productionTip = false;

app.use(router);
app.use(antd);
app.mount('#app');
