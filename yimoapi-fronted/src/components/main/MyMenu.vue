<template>
  <Menu :active-name="this.$route.name" style="height: 90vh" width="12vw">
    <MenuGroup title="快速入门">
      <MenuItem name="introduction" to="/home/introduction">
        <Icon type="md-bookmark" />
        简介
      </MenuItem>
      <MenuItem name="quickstart" to="/home/quickstart">
        <Icon type="ios-flash" />
        快速开始
      </MenuItem>
      <MenuItem name="install" to="/home/install">
        <Icon type="md-document" />
        安装
      </MenuItem>
    </MenuGroup>
    <MenuGroup title="接口文档">
      <MenuItem name="freeapi" to="/home/freeapi">
        <Icon type="md-heart"  />
        免费接口
      </MenuItem>
      <MenuItem name="payapi" to="/home/payapi">
        <Icon type="md-pricetags"/>
        付费接口
      </MenuItem>
    </MenuGroup>
    <MenuGroup title="其它">
      <MenuItem name="qa" to="/home/qa">
        <Icon type="md-help-circle" />
        Q&A
      </MenuItem>
    </MenuGroup>
  </Menu>
  <br>
</template>

<script>
import Install from "./Install.vue";

export default {
  name: "MyMenu",
  computed: {
    Install() {
      return Install
    }
  },
  data () {
    return {
      // theme: 'light'
      active: "introduction"
    }
  },
  watch: {
    $route(to,from){
      // console.log(to.path);
      // console.log(from.path)
      // console.log(to.name);
      // console.log(from.name)
      // console.log(this.$route)
      // console.log(to.path.substring(6))
      // this.active = to.path.substring(6)
    }

  }
}
</script>

<style scoped>

</style>