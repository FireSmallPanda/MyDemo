<template>
  <div>

    <div class="row">
      <div class="border col-xs-4 col-xs-offset-4 loginBox">
        <div class="form-group">
          <label for="account" class="col-xs-4 control-label">账号</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" id="account" v-model="account" placeholder="请输入账号">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-xs-4 control-label">密码</label>
          <div class="col-xs-8">
            <input type="password" class="form-control" id="password" v-model="password" placeholder="请输密码">
          </div>
        </div>
        <div class="col-sm-offset-4 col-sm-4">
          <input class="btn btn-primary loginBtn" type="button" value="登录">
        </div>
      </div>
    </div>

    {{account}} || {{password}}

  </div>
</template>

<script>
  export default{
    name: "login",
    data () {
      return {
        msg: '',
        account: '',// 账号
        password: '' // 密码
      }
    }
  }
</script>

<style scoped>
  .border{
    border: 1px solid red;
  }
  .loginBox{


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
