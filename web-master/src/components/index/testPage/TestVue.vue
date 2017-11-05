<template>
  <div id="test">
      这是一个测试页面
      <icon name="close" :scale="1"></icon>
        <modal-window :modalProp="modalProp"></modal-window>
  </div>
  
</template>

<script>
import ModalWindow from "@/components/common/ModalWindow"
export default {
  data() {
    return {
      msg: "",
      modalProp:{ // 模态窗属性
        title:"ssd"

      }


    };
  },
  methods: {
  
  },
  created() {
       
  },
  components:{

ModalWindow

  }
  
};
</script>

<style scoped>

</style>
