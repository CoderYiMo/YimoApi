<template>
  <div class="outside">
    <div class="top">
      <bread></bread>
    </div>
    <div class="bottom">
      <div class="left">
        <my-menu></my-menu>
      </div>
      <div class="right">
        <div class="content">
          <router-view/>
        </div>
<!--        <div class="footer">-->
<!--          <my-footer></my-footer>-->
<!--        </div>-->
      </div>
    </div>
  </div>
</template>

<script setup>
import MyMenu from "../../components/main/MyMenu.vue";
import MyFooter from "../../components/main/MyFooter.vue";
import Bread from "../../components/main/Bread.vue";
import {userInfoStore} from "../../store/piniaStore";
import {onBeforeMount} from "vue";
import {getMenu, getUserBaseInfo} from "../../api/home";

onBeforeMount(()=>{
  // 获取用户基本信息
 getLoginUser()
 //  // 获取用户菜单
  getUserMenu()
})
const store = userInfoStore()
const getLoginUser = async () => {
  const res =  await getUserBaseInfo(store.userToken)
  // console.log(res.data.data)
  store.$patch({
    userBaseInfo: res.data.data
  })
}
const getUserMenu = async () => {
  // console.log(store.userBaseInfo.userRole)
  const res =  await getMenu(store.userBaseInfo.userRole)
  // console.log(res.data.data)
  store.$patch({
    userMenu: res.data.data
  })
}

</script>

<style scoped lang="less">
.outside{
  .top{
    box-shadow: 0 1px 10px #D2CDCD;
    width: 100vw;
    position: fixed;
    top: 0;
  }
  .bottom{
    display: flex;
    .left{
      position: fixed;
      top: 80px;
    }
    .right{
      position: fixed;
      top: 100px;
      left: 15vw;
      width: 82vw;
      overflow: hidden;
      .content{
        //border: 1px solid #000;
        width: calc(82vw + 17px);
        height: 85vh;
        padding-right: 5px;
        overflow-y: scroll;
      }
      //.footer{
      //  //border: 1px solid #000;
      //  position: fixed;
      //  bottom: 0;
      //  width: 82vw;
      //}
    }
  }
}
</style>