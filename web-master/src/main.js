// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './vuex/index' // 导入 vuex配置 src/vuex/index.js
import Icon from 'vue-svg-icon/Icon.vue'; // 图标
import $ from 'jquery' 
Vue.config.productionTip = false
Vue.component('icon', Icon);  
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store:store,
  template: '<App/>',
  components: { App }
})
