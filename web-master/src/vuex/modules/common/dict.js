/**
 * Created by Administrator on 2017/6/20.
 */
import Vue from 'vue';
import Vuex from 'vuex';
import session from '@/common/js/sessionstorageUtil.js';
import _ from 'lodash';
Vue.use(Vuex);
// action
const getSystemDicts = "dict/getSystemDicts";
const dict1 = "dict1";

export default{
  state: {
    dicts: [
      {value: "", text: ""}
    ], // 字典


  },

  mutations: {
    [getSystemDicts](state) { // 改变path
      state.dicts = session.fetch("dicts")
    },
  },
  getters: {
    [dict1]: state => { // 登录类型
      return state.dicts.filter(item => item.group_id == "1");
    },
    
  },

  actions: {
    [getSystemDicts]({commit, state}){ // 获取字典
      // 保存数据
      commit(getSystemDicts);
      if (state.dicts != null && state.dicts.length > 1) { // 如果已经有则不用请求后台
        return;
      }
      $.ajax({
        type: "post",
        url: "api/system/loadAllDict.do",
        data: {},
      }).then((response) => {
        if (response.state) {
          // session 保存数据
          session.save("dicts", response.data);
          // 保存数据
          commit(getSystemDicts);
        } else {
          // alert(response.message)
        }
      }).catch((respone) => {
        var dicts = [
          {value: "", text: ""}
        ];
        session.save("dicts", dicts);
        commit(getSystemDicts);
        console.log("发生错误");
      });
    }
  }

}
