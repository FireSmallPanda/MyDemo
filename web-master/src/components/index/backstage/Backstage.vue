<template>
  <div id="back-stage">
    <div class="back-stage-top">Top</div>
    <div class="back-stage-mid">
      <div class="row">
        <div class="col-xs-4">
          4
        </div>
        <div class="col-xs-8">
          8
        </div>
      </div>
      <div class="back-stage-foot">foot</div>
    </div>
  </div>
</template>

<script>
  import cookieUtil from "@/common/js/cookieUtil"
  export default{
    data () {
      return {
        msg: '',
        loginUser:{}

      }
    },
    methods:{
        // 检查登录
        checkLogin(){
          // 获取登录信息
          this.loginUser = cookieUtil.get("loginUser");
          if(!this.loginUser){
            this.$router.push('/');//跳转登录
          }
        }
    },
    created(){
        this.checkLogin();

    }
  }
</script>

<style scoped>
  .back-stage {
    height: 100%;
  }
</style>
