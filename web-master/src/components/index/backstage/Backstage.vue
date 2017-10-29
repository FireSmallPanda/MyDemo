<template>
  <div id="back-stage">
    <div class="back-stage-top">Top 你好！{{loginUser.id}}</div>
    <div class="back-stage-mid">
      <div class="row">
        <div class="col-xs-1">
          <menu-left :menuProp="menuProp"></menu-left>
        </div>
        <div class="col-xs-11">
           <router-view></router-view>
        </div>
      </div>
      <div class="back-stage-foot text-center">由小熊猫提供技术支持 QQ1020529941</div>
    </div>
  </div>
</template>

<script>
import cookieUtil from "@/common/js/cookieUtil";
import MenuLeft from "@/components/common/index/MenuLeft";
export default {
  data() {
    return {
      msg: "",
      loginUser: {},
      menuProp: { // 菜单参数
        defaultSelect:"/backHome", // 默认选中
        menuList: [ // 菜单列表
          { text: "首页", href: "/backHome" ,select:true},
          { text: "安全中心", href: "safeInfo" },
          { text: "退出登录", href: "/loginOut" }
        ]
      }
    };
  },
  methods: {
    // 检查登录
    checkLogin() {
      // 获取登录信息
      this.loginUser = cookieUtil.get("loginUser");
      if (!this.loginUser) {
        this.$router.push("/"); //跳转登录
      }
    }
  },
  components: {
    MenuLeft
  },
  created() {
    this.checkLogin();
  }
};
</script>

<style scoped>
.row {
  margin: 0px;
  padding: 0px;
}
.row div {
  padding: 0px;
}
#back-stage {
  height: 100%;
}
.back-stage-top {
  height: 10%;
  background-color: aqua;
}
.back-stage-mid {
  height: 80%;
}
.back-stage-foot {
  height: 10%;
  width: 100%;
  background-color: #fff;
  position: fixed;
  bottom: 0;
}
</style>
