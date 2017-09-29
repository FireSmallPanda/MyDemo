/**
 * Created by Administrator on 2017/6/20.
 */
import Vue from 'vue';
import Vuex from 'vuex';

import demo from './modules/demo/demo';
import common from './modules/common/common';

const test = "test";


Vue.use(Vuex);
const store = new Vuex.Store({
  modules: {
    demo,common
  },
  state: {
    data: {
    }
  },

  mutations: {},

  actions: {
    [test]({commit}){ // 改变pshow
      alert("aa");
      //commit('changePShow');
    },

  }

})

export default store;
