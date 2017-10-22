import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/index/login/Login' // 登录页面
import Backstage from '@/components/index/backstage/Backstage' // 后台页面
import LoginOut from '@/components/index/backstage/loginOut/LoginOut' // 登出
Vue.use(Router)

export default new Router({
  routes: [
    { path: '*', component: Login },
    {
      path: '/backstage', component: Backstage,
      children: [
        { path: '/loginOut', component: LoginOut }
      ]
    },
    { path: '/login', component: Login },
  ],
})
