<template>
  <div id="safe-centrality">
    安全中心
    <table class="table table-bordered">
      <tr>
        <th>ip</th>
        <th>抄作内容</th>
        <th>操作时间</th>
      </tr>
      <tr v-for="item in logList">
        <td>{{item.ip}}</td>
        <td>{{item.action}}</td>
        <td>{{item.action_time}}</td>
      </tr>
    </table>
    <span @click="changePageSearch('pre')" >上一页</span> <span>{{logInfo.thisPage}}/{{logInfo.pageNum}}</span><span @click="changePageSearch('next')">下一页</span>
  </div>
</template>

<script>
import cookieUtil from "@/common/js/cookieUtil";
import MenuLeft from "@/components/common/index/MenuLeft";
import commonUtil from "@/common/js/commonUtil";
import {mapState, mapGetters} from 'vuex';
import dictUtil from "@/common/js/dictUtil";
export default {
  data() {
    return {
      logInfo:{ // 查询日志信息
        thisPage:1,
        pageSize:10,
        pageNum:0
      },
      logList:[   // 日志列表
      ] 
    }
      
  },
  computed: {
      ...mapGetters({
        dict1:'dict1' // 日志类型
      }),
  },
  methods: {
    // （L1）用户日志查看
    getLogList() {
      var formVals = {};
      // 赋值信息
      formVals.thisPage = this.logInfo.thisPage;
      formVals.pageSize = this.logInfo.pageSize;
      $.ajax({
        type: "post",
        url: "api/log/searchLogByPage.do",
        data: formVals,
      }).then((response) => {
        if (response.state) {
         this.logList = response.data.list;
         this.logInfo.pageNum  = response.data.pageNum;

        this.logList.forEach((item)=>{ // 翻译及转义
            item.action_time = commonUtil.getDateString(item.action_time);
            item.action =  dictUtil.getDictText(this.dict1,item.action);
        });

        } else {
          alert(response.msg);
        }
      }).catch((response) => {
        console.log("发生错误");
      });
    },
    // 翻页查询
    changePageSearch(pageFlag){
        if(pageFlag=='pre'){
            if(this.logInfo.thisPage<=1){
              alert("没有上一页了！");
              return;

            }else{
              this.logInfo.thisPage--;

            }
        }else{
          if(this.logInfo.thisPage>=this.logInfo.pageNum){
              alert("没有下一页了！");
              return;
            }else{
              this.logInfo.thisPage++;
            }
        }
       // 用户日志查看
       this.getLogList();

    }


  },
  components: {
    
  },
  created() { // 载入时
    // 用户日志查看
    this.getLogList();
  }
};
</script>

<style scoped>

</style>
