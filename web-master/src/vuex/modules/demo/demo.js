/**
 * Created by Administrator on 2017/6/20.
 */
import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
// const changePShow  = "demo/changePShow";

export default{
  state: {
    data:{

    },
    pageAmin:{

    },
  },

  mutations: {
    // [changePShow](state) { // 改变pshow
    //   state.pageAmin.pShow = !state.pageAmin.pShow;
    // },

  },
  getters: {
    // [doneTodos]: state => {
    //   return state.data.todos.filter(todo => todo.text=="vvvv")
    // }
  },
  actions: {
    // // 如有相同方法则全调用
    // [changePShow]({commit}){ // 改变pshow
    //   commit(changePShow);
    // },
    //
  }

}
