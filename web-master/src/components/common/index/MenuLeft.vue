<template>
    <div>
      <ul class="nav nav-pills nav-stacked">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages</a></li>
      </ul>
    </div>
</template>

<script>
    export default{
        data () {
            return {
                msg: ''
            }
        }
    }
</script>

<style scoped>
.active{}
</style>
