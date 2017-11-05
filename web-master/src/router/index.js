import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/index/login/Login' // 登录页面
import Backstage from '@/components/index/backstage/Backstage' // 后台页面
import LoginOut from '@/components/index/backstage/loginOut/LoginOut' // 登出
import BackHome from '@/components/index/backstage/backHome/BackHome' // 后台主页

import TestVue from '@/components/index/testPage/TestVue' // 测试页面
Vue.use(Router)

export default new Router({
  routes: [
    { path: '*', component: Login },
    {
      path: '/backstage', component: Backstage,
      children: [
        { path: '/loginOut', component: LoginOut },
        { path: '/backHome', component: BackHome }
      ]
    },
    { path: '/login', component: Login },
    { path: '/test', component: TestVue },
  ],
})
