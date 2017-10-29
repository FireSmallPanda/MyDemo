<template>
  <div id="loginOut">
    登出
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: ""
    };
  },
  methods: {
    //U2登出
    loginOut() {
      $.ajax({
        type: "post",
        url: "api/user/userLoginOut.do"
      })
        .then(response => {
          if (response.state) {
            alert("登出成功！")
            this.$router.push("/login"); //跳转登录
          } else {
            alert(response.msg);
          }
        })
        .catch(response => {
          console.log("发生错误");
        });
    }
  },
  created() {
    // 登出
    this.loginOut();
  }
};
</script>

<style scoped>

</style>
