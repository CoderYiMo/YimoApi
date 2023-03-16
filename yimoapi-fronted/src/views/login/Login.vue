<template>
  <div class="page">
    <div class="left-container">
      <img src="../../assets/login/image1.png"  alt="" class="left-image" />
    </div>
    <div class="right-container">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {

    }
  }
}
</script>

<style scoped lang="less">
.page{
  display: flex;
}
.left-container{
  //border: 1px solid #000;
  width: 50vw;
  height: 100vh;
  .left-image{
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
}
.right-container{
  //border: 1px solid #000;
  width: 50vw;
}
</style>
