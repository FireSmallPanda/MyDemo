<template>
  <div id="login-body">
    <div class="login-heard"></div>
    <div class="panel panel-default loginBox col-xs-offset-4">
      <div class="panel-heading">
        <h4>登录</h4>
      </div>
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
              <input class="btn btn-default loginBtn" type="button" value="去注册" @click="registShow(true)">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="login-foot">地址</div>
    <modal-window :modalProp="registModal" v-if="registModal.show" @closeClick="registShow" >
      <div class="row">
          <div class="col-xs-10">
             <div class="form-group"> 
              <div  class="col-xs-4 text-right lable-text from-son"><span class="red">*</span>注册方式</div>
              <div class="col-sm-8 from-son">
                <input type="text" class="form-control"  v-model="registInfo.way" placeholder="这是一个下拉">
                <span class="red">{{registInfo.wayMsg}}</span>
              </div>
            </div>
            <div class="form-group">
              <div  class="col-xs-4 text-right lable-text from-son"><span class="red">*</span>邮箱</div>
              <div class="col-sm-8 from-son">
                <input type="text" class="form-control"  v-model="registInfo.email" placeholder="请输入邮箱"  @blur="registCheckInfo(false)">
                <span :class="registInfo.emailFlag" v-if="registInfo.emailFlag" >{{registInfo.emailMsg}}</span>
              </div>
            </div>
            <div class="form-group">
              <div  class="col-xs-4 text-right lable-text from-son"><span class="red">*</span>手机</div>
              <div class="col-sm-8 from-son">
                <input type="text" class="form-control"  v-model="registInfo.tel" placeholder="请输入手机号"  @blur="registCheckInfo(false)" >
                <span :class="registInfo.telFlag" v-if="registInfo.telFlag">{{registInfo.telMsg}}</span>
              </div>
            </div>
            <div class="form-group">
              <div  class="col-xs-4 text-right lable-text from-son"><span class="red">*</span>账号</div>
              <div class="col-sm-8 from-son">
                <input type="text" class="form-control"  v-model="registInfo.account" placeholder="请输入账号" @blur="registCheckInfo(false)">
                <span :class="registInfo.accountFlag" v-if="registInfo.accountFlag" >{{registInfo.accountMsg}}</span>
              </div>
            </div>
            <div class="form-group" >
              <div  class="col-xs-4 text-right from-son lable-text"><span class="red">*</span>密码</div>
              <div class="col-xs-8 from-son">
                <input type="password" class="form-control" v-model="registInfo.password" placeholder="请输密码"  @blur="registCheckInfo(false)" >
                <span :class="registInfo.passwordFlag" v-if="registInfo.passwordFlag" >{{registInfo.passwordMsg}}</span>
              </div>
            </div>
             <div class="form-group" >
              <div  class="col-xs-4 text-right from-son lable-text"><span class="red">*</span>确认密码</div>
              <div class="col-xs-8 from-son">
                <input type="password" class="form-control"  v-model="registInfo.rePassword" placeholder="请输确认密码"  @blur="registCheckInfo(false)">
                <span :class="registInfo.rePasswordFlag" v-if="registInfo.rePasswordFlag">{{registInfo.rePasswordMsg}}</span>
              </div>
            </div>
             <div class="col-sm-offset-6 col-sm-4 from-son">
              <input class="btn btn-primary loginBtn" type="button" value="注册" @click="regist">
            </div>
        </div>
        
      </div>    
    </modal-window>
  </div>
</template>

<script>
import ruleUtil from "@/common/js/ruleUtil"
import cookieUtil from "@/common/js/cookieUtil"
import ModalWindow from "@/components/common/ModalWindow"



export default {
  
  name: "login",
  data() {
    return {
      msg: '',
      loginInfo: { // 登录信息
        account: "",
        password: ""
      },
      registModal:{ // 模态窗属性
        title:"注册",
        show:false // 是否显示
      },

      registInfo:{ //注册信息
        way:"",
        wayFlag:"",
        wayMsg:"",

        email:"",
        emailFlag:"",
        emailMsg:"",

        tel:"",
        telFlag:"",
        telMsg:"",

        account:"",
        accountFlag:"",
        accountMsg:"",

        password:"",
        passwordFlag:"",
        passwordMsg:"",

        rePassword:"",
        rePasswordFlag:"",
        rePasswordMsg:"",

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

    //打开注册窗口
    registShow(flag){

      this.registModal.show  = flag;
    },
    regist(){
     
        
        alert("正在开发")

    },

    registCheckInfo(flag){ // 检查注册信息 flag 是否同步验证
      


      // 邮箱
      if(!ruleUtil.checkEmail(this.registInfo.email)){
        this.registInfo.emailFlag="error";
        this.registInfo.emailMsg="邮箱格式错误！例：aaa@163.com"
        if(!flag){
          return;
        }
      }else{
        this.registInfo.emailFlag=false;
      }
    // 手机
      if(!ruleUtil.checkTel(this.registInfo.tel)){
        this.registInfo.telFlag="error";
        this.registInfo.telMsg="手机号格式错误！例：13100000000"
        if(!flag){
          return;
        }
      }else{
        this.registInfo.telFlag=false;
      }
    // 账号
      if(!ruleUtil.checkAccount(this.registInfo.account)){
        this.registInfo.accountFlag="error";
        this.registInfo.accountMsg="账号格式错误！4到16位（字母，数字，下划线，减号）"
        if(!flag){
          return;
        }
      }else{
        this.registInfo.accountFlag=false;
      }


      // 密码
      if(ruleUtil.checkPassword(this.registInfo.password)==1){
        this.registInfo.passwordFlag="warning";
        this.registInfo.passwordMsg="密码过于简单！建议数字+字符、特殊字符"
        /*if(!flag){
          return;
        }*/
      }else if(ruleUtil.checkPassword(this.registInfo.password)==3){
        this.registInfo.passwordFlag=false;
      }else if(ruleUtil.checkPassword(this.registInfo.password)==2){
        this.registInfo.passwordFlag=false;
      }else{
        this.registInfo.passwordFlag="error";
        this.registInfo.passwordMsg="密码不符合规范！必须大于6位！建议数字+字符、特殊字符"
        if(!flag){
          return;
        }
      }
      if(this.registInfo.password!=this.registInfo.rePassword){
          this.registInfo.rePasswordFlag="error";
          this.registInfo.rePasswordMsg="两次密码输入不一致！"
          if(!flag){
            return;
          }
        }else{
          this.registInfo.rePasswordFlag=false;
        }



    }


  },
  components:{
      ModalWindow
  }

}
</script>

<style scoped>
@import "/static/css/login/login.css";

</style>
