<template>
  <Alert type="success">
    <div class="alert-title">提示</div>
    <template #desc>
      <div class="alert-description">SDK基于JDK8，引入此依赖的项目请使用JDK8+版本</div>
    </template>
  </Alert>
  <div class="release">Release</div>
  <Divider class="divider"/>
  <div class="springboot">Spring Boot</div>
  <div class="maven">Maven:</div>
  <div>
    <code-display :code-text="dependency" class="codeDisplay"></code-display>
  </div>
  <div class="updateTime">
    <div class="t1">上次更新：</div>
    <div class="t2">2023/02/20,15:32:09</div>
  </div>
  <Divider plain>THE END</Divider>
  <MyFooter></MyFooter>
</template>

<script>
import CodeDisplay from "./CodeDisplay.vue";
import MyFooter from "./MyFooter.vue";

export default {
  name: "Install",
  components: {MyFooter, CodeDisplay},
  data(){
    return{
      dependency: '<dependency>\n' +
          '    <groupId>com.baomidou</groupId>\n' +
          '    <artifactId>mybatis-plus-boot-starter</artifactId>\n' +
          '    <version>最新版本</version>\n' +
          '</dependency>'
    }
  }
}
</script>

<style scoped lang="less">
.alert-title{
  color: #215d42;
  font-weight: bold;
}
.alert-description{
  color: #215d42;
}
.release{
  //border: 1px solid #000;
  color: #004050;
  font-size: 22px;
}
.divider{
  //border: 1px solid #000;
  margin: 4px 0;
}
.springboot{
  margin-top: 10px;
  color: #004050;
  font-size: 22px;
}
.maven{
  color: #004050;
  font-size: 15px;
  margin-top: 10px;
}
.codeDisplay{
  margin-top: 10px;
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