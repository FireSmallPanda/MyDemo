<template>
    <div>
      <ul class="nav nav-pills nav-stacked">
        <li  v-for="item in menuList"  role="presentation" :class="selectMenu==item.href?'active':''" @click="clickMenu(item.href)" >
            <router-link router-link :to="{ path: item.href }">{{item.text}}</router-link>
        </li>
      </ul>
    </div>
</template>

<script>
    export default{
        data () {
            return {
                msg: '',
                menuList: this.menuProp.menuList|[], // 菜单列表
                selectMenu:'nullisss',// 当前选中菜单
            }
        },
        props:["menuProp"],
        methods:{
            clickMenu(value){ // 选中菜单

                this.selectMenu = value;             

            }

        },
        created(){
            // 赋值菜单
            this.menuList = this.menuProp.menuList;
            //赋值默认选中
            this.selectMenu = this.menuProp.defaultSelect;

        }
    }
</script>

<style scoped>
.active{}
</style>
