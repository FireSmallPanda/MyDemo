import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/index/login/Login' // Iview组件


Vue.use(Router)

export default new Router({
  routes: [
    { path: '*', component: Login },
  ],
})
