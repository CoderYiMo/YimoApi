<template>
  <div class="outside">
    <div class="left">
      <img src="../../assets/logo.png" />
      <div class="title">壹默接口</div>
    </div>
      <div class="right">
        <div class="refreshLog">
          <div>更新日志</div>
          <Icon type="md-open" class="icon"/>
        </div>
        <div class="github">
          <div>Github</div>
          <Icon type="md-open" class="icon"/>
        </div>
    </div>
  </div>
</template>

<script>
import {userInfoStore} from "../../store/piniaStore";
export default {
  data(){
    return{

    }
  },
  methods:{

  }
}
</script>

<style scoped lang="less">
.outside{
  //border: 1px solid #000;
  height: 70px;
  display: flex;
  justify-content: space-between;
  .left{
    display: flex;
    img{
      width: 60px;
      height: 60px;
      margin: auto 20px;
    }
    .title{
      font-size: 25px;
      line-height: 70px;
    }
  }
  .right{
    //border: 1px solid #000;
    display: flex;
    justify-content: right;
    margin-right: 100px;
    font-size: 18px;
    width: 300px;
    color: #004050;
    .refreshLog{
      display: flex;
      margin: auto 20px auto 0;
      //border: 1px solid #000;
      .icon{
        margin: auto 0 auto 2px;
      }
    }
    .github{
      display: flex;
      margin: auto 0;
      .icon{
        margin: auto 0 auto 2px;
      }
    }
  }
}
</style>