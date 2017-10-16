<template>
  <div>

    <div class="row">
      <div class="border col-xs-4 col-xs-offset-4 loginBox">
        <div class="form-group">
          <label for="account" class="col-xs-4 control-label">账号</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="account" v-model="loginInfo.account" placeholder="请输入账号">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-xs-4 control-label">密码</label>
          <div class="col-xs-8">
            <input type="password" class="form-control" id="password" v-model="loginInfo.password" placeholder="请输密码">
          </div>
        </div>
        <div class="col-sm-offset-4 col-sm-4">
          <input class="btn btn-primary loginBtn" type="button" value="登录" @click="login" >
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  import ruleUtil from "@/common/js/ruleUtil"
  import cookieUtil from "@/common/js/cookieUtil"
  export default{
    name: "login",
    data () {
      return {
        msg: '',
        loginInfo:{ // 登录信息
          account:"",
          password:""
        }

      }
    },
    methods:{
      // U1用户登录
      login(){
        var formVals = {};
        // 赋值信息
        formVals.account = this.loginInfo.account;
        formVals.password = this.loginInfo.password;
        $.ajax({
          type: "post",
          url: "api/user/userLogin.do",
          data: formVals,
        }).then((response) => {
          if (response.state) {
            // 保存登录信息
            cookieUtil.save("loginUser",response.data.loginUser);
            this.$router.push('/backstage');//跳转后端
          }else{
            alert(response.msg);
          }
        }).catch((response) => {
          console.log("发生错误");
        });

      }

    }

  }
</script>

<style scoped>
  .border{
    border: 1px solid red;
  }
  .loginBox{
    margin-top: 15%;
  }
  .row{
    margin: 0px;
    padding: 0px;
  }
  .row div{
    padding: 0px;
  }
  label{
    padding-top: 5 px;
  }
  .loginBtn{
    width: 7rem;
  }
</style>
