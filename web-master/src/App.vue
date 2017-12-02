<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import {mapState,mapActions} from 'vuex';
export default {
    
  data() {
    return {
      msg: ""
    };
  },
  methods: {
    
  },
  created() {
   this.$store.dispatch('dict/getSystemDicts')
  }
};
</script>

<style>

</style>
