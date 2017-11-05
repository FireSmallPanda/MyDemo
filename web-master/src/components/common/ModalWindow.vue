<template>
  <div class='modalWindow' >
    <div class="panel panel-default modalBox col-xs-offset-4">
      <div class="panel-heading">
        <div class="row">
          <div class=" col-xs-1"></div>
          <div class=" col-xs-10 text-center"><h4>{{modalProp.title?modalProp.title:"模态窗"}}</h4></div>
          <div class=" col-xs-1" @click="closeClick" ><icon name="close" :scale="2" @click="closeClick" ></icon></div>
        </div>
      </div>
      <div class="panel-body">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'modalWindow',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        sizeClass:"" // 大小类型
      }
    },
    props: ['modalProp'],
    methods: {
      leftClick () {
        this.$emit("leftClick", "")
      },
      leftClick(){
        this.$emit("leftClick", "")
      },
      closeClick(){
        this.$emit("closeClick", false)
      }
    }
  }
</script>
<style scoped>
.modalBox{
      width: 30%;
    position: fixed;
    top: 30%;
}

  .modalWindow {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0,0,0,.3);
    z-index: 999;
  }
</style>
