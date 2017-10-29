<template>
  <div id="login-body">
    <div class="login-heard"></div>
    <div class="panel panel-default loginBox col-xs-offset-4">
      <div class="panel-heading"><h4>登录</h4></div>
      <div class="panel-body">
        <div class="text-center">欢迎使用小熊猫VO</div>
        <div class="row">
          <div class="col-xs-10">
            <div class="form-group">
              <div  class="col-xs-4 text-right lable-text">账号</div>
              <div class="col-sm-8">
                <input type="text" class="form-control" id="account" v-model="loginInfo.account" placeholder="请输入账号">
              </div>
            </div>
            <div class="form-group" >
              <div  class="col-xs-4 text-right from-son lable-text">密码</div>
              <div class="col-xs-8 from-son">
                <input type="password" class="form-control" id="password" v-model="loginInfo.password" placeholder="请输密码">
              </div>
            </div>
            <div class="col-sm-offset-4 col-sm-4 ">
              √记住账号
            </div>
            <div class=" col-sm-4 ">
              忘记密码？
            </div>
            <div class="col-sm-offset-4 col-sm-4 from-son">
              <input class="btn btn-primary loginBtn" type="button" value="登录" @click="login">
            </div>
            <div class=" col-sm-4 from-son">
              <input class="btn btn-default loginBtn" type="button" value="去注册" @click="sign">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="login-foot">地址</div>
  </div>
</template>

<script>
import ruleUtil from "@/common/js/ruleUtil"
import cookieUtil from "@/common/js/cookieUtil"
export default {
  name: "login",
  data() {
    return {
      msg: '',
      loginInfo: { // 登录信息
        account: "",
        password: ""
      }

    }
  },
  methods: {
    // U1用户登录
    login() {
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
          cookieUtil.save("loginUser", response.data.loginUser);
          this.$router.push('/backHome');//跳转后端主页
        } else {
          alert(response.msg);
        }
      }).catch((response) => {
        console.log("发生错误");
      });

    },
    sign(){

      alert("正在研发");
    }

  }

}
</script>

<style scoped>
.border {
  border: 1px solid red;
}
#login-body{
background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508434141913&di=fdd0b11e45603b8d12a6c238b71cee8b&imgtype=0&src=http%3A%2F%2Ffile06.16sucai.com%2F2016%2F0624%2F502158493606b5ebbaee7f5ace5c497c.jpg");
padding-bottom: 1px;
}

.login-heard{
     margin-top: 15%;
    padding-top: 24px;
    height: 0px;
}

.loginBox {
  width: 30%;
}
.from-son{
 padding-top: 10px;
}
.row {
}
label {
  padding-top: 5 px;
}

.loginBtn {
  width: 7rem;
}
.lable-text{
  font-size: 1.8rem;

}
.login-foot{
  position:fixed; bottom:0; 
  width: 100%;

}
</style>
