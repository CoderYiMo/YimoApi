<template>
  <div class="t1">壹默接口是一个API开放平台，它由SDK、用户中心、开发者中心和接口文档组成，为简化开发、提高效率而生。</div>
  <Alert type="success" class="alert">
    <div class="alert-title">愿景</div>
    <template #desc>
      <div class="alert-description">我们的愿景是成为众多优秀开发者接入并为用户提供高质量接口的平台。</div>
    </template>
  </Alert>
  <div class="features">
    <div class="title">特性</div>
    <Divider class="divider"/>
    <List border class="list">
      <ListItem v-for="(item) in featureList" >
        <div class="simple">{{item.simple}}</div>
        <div class="intro">：{{item.intro}}</div>
      </ListItem>
    </List>
  </div>
  <div class="contribute">
    <div class="title">参与贡献</div>
    <Divider class="divider"/>
    <div class="text">欢迎各路好汉一起来参与完善壹默接口，我们期待你的Idea!</div>
  </div>
  <div class="updateTime">
    <div class="t1">上次更新：</div>
    <div class="t2">2023/03/06,18:15:21</div>
  </div>
  <Divider plain>THE END</Divider>
  <MyFooter></MyFooter>
</template>

<script>
import MyFooter from "./MyFooter.vue";

export default {
  name: "Introduction",
  components: {MyFooter},
  data(){
    return{
      featureList:[
        {
          simple: '配置简单',
          intro: '只需要配置AK和SK'
        },
        {
          simple: '使用简单',
          intro: '引入依赖后，一个简单方法调用一个强大的功能接口'
        },
        {
          simple: '安全性',
          intro: 'AK或者SK泄露后，可以及时更换并且生效，不用担心恶意消耗调用次数'
        },
        {
          simple: '开放性',
          intro: '只要申请成为开发者，并且接口质量优质，就能被整合进入SDK供用户使用'
        },
      ]
    }
  }
}
</script>

<style scoped lang="less">
.t1{
  font-size: 16px;
  color: #215d42;
}
.alert{
  margin-top: 20px;
  .alert-title{
    color: #215d42;
    font-weight: bold;
  }
  .alert-description{
    color: #215d42;
  }
}
.features{
  margin-top: 30px;
  .title{
    color: #004050;
    font-size: 22px;
    font-weight: bold;
  }
  .divider{
    margin: 4px 0;
  }
  .list{
    margin-top: 20px;
    .simple{
      color: #004050;
      font-weight: bold;
    }
    .intro{
      color: #004050;
    }
  }
}
.contribute{
  margin-top: 30px;
  .title{
    color: #004050;
    font-size: 22px;
    font-weight: bold;
  }
  .divider{
    margin: 4px 0;
  }
  .text{
    font-size: 16px;
    margin-top: 20px;
    color: #215d42;
  }
}
.updateTime{
  display: flex;
  justify-content: right;
  margin-top: 20px;
  .t1{
    color: #336673;
  }
  .t2{
    color: #aaa;
  }
}
</style>