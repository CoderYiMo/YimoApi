<template>
  <div class="initial">
    <div class="title">初始化工程</div>
    <Divider class="divider"/>
    <div class="text">创建一个空的Spring Boot工程</div>
    <Alert type="success" class="alert">
      <div class="alert-title">提示</div>
      <template #desc>
        <div class="alert-description">可以使用Spring Initializer快速初始化一个 Spring Boot 工程</div>
      </template>
    </Alert>
  </div>
  <div class="out">
    <div class="title">添加依赖</div>
    <Divider class="divider"/>
    <div class="text">引入 Spring Boot Starter 父工程：</div>
    <code-display class="codeDisplay" :code-text="springStarterCode"></code-display>
    <div class="text">引入spring-boot-starter、spring-boot-starter-test、xxx依赖：</div>
    <code-display class="codeDisplay" :code-text="allDependency"></code-display>
  </div>
  <div class="out">
    <div class="title">配置</div>
    <Divider class="divider"/>
    <div class="text">在application.yml配置文件中添加壹默接口SDK的相关配置：</div>
    <code-display class="codeDisplay" :code-text="ymlCode"></code-display>
  </div>
  <div class="out">
    <div class="title">开始使用</div>
    <Divider class="divider"/>
    <div class="text">添加测试类进行功能测试：</div>
    <code-display class="codeDisplay" :code-text="testCode"></code-display>
    <div class="text">控制台输出：</div>
    <code-display class="codeDisplay" :code-text="consoleText"></code-display>
  </div>
  <div class="out">
    <div class="title">小结</div>
    <Divider class="divider"/>
    <div class="text">通过以上几个简单的步骤，我们就实现了调用接口，从而可以帮助简化开发！</div>
    <div class="text">从以上步骤中，我们可以看到集成壹默接口SDK非常简单，只需要引入 starter 工程，并自动装配client对象即可。</div>
    <div class="text">通过以上几个简单的步骤，我们就实现了调用接口，从而可以帮助简化开发！</div>
  </div>
  <div class="updateTime">
    <div class="t1">上次更新：</div>
    <div class="t2">2023/03/06,22:23:18</div>
  </div>
  <Divider plain>THE END</Divider>
  <MyFooter></MyFooter>
</template>

<script>
import CodeDisplay from "./CodeDisplay.vue";
import MyFooter from "./MyFooter.vue";

export default {
  name: "QuickStart",
  components: {MyFooter, CodeDisplay},
  data(){
    return{
      springStarterCode: '<parent>\n' +
          '    <groupId>org.springframework.boot</groupId>\n' +
          '    <artifactId>spring-boot-starter-parent</artifactId>\n' +
          '    <version>2.0+ 版本</version>\n' +
          '    <relativePath/>\n' +
          '</parent>',
      allDependency: '<dependencies>\n' +
          '    <dependency>\n' +
          '        <groupId>org.springframework.boot</groupId>\n' +
          '        <artifactId>spring-boot-starter</artifactId>\n' +
          '    </dependency>\n' +
          '    <dependency>\n' +
          '        <groupId>org.springframework.boot</groupId>\n' +
          '        <artifactId>spring-boot-starter-test</artifactId>\n' +
          '        <scope>test</scope>\n' +
          '    </dependency>\n' +
          '    <dependency>\n' +
          '        <groupId>com.baomidou</groupId>\n' +
          '        <artifactId>mybatis-plus-boot-starter</artifactId>\n' +
          '        <version>最新版本</version>\n' +
          '    </dependency>\n' +
          '</dependencies>',
      ymlCode: '# DataSource Config\n' +
          'spring:\n' +
          '  datasource:\n' +
          '    driver-class-name: org.h2.Driver\n' +
          '    schema: classpath:db/schema-h2.sql\n' +
          '    username: root\n' +
          '    password: test\n' +
          '  sql:\n' +
          '    init:\n' +
          '      schema-locations: classpath:db/schema-h2.sql\n' +
          '      data-locations: classpath:db/data-h2.sql',
      testCode: '@SpringBootTest\n' +
          'public class SampleTest {\n' +
          '\n' +
          '    @Autowired\n' +
          '    private UserMapper userMapper;\n' +
          '\n' +
          '    @Test\n' +
          '    public void testSelect() {\n' +
          '        System.out.println(("----- selectAll method test ------"));\n' +
          '        List<User> userList = userMapper.selectList(null);\n' +
          '        Assert.assertEquals(5, userList.size());\n' +
          '        userList.forEach(System.out::println);\n' +
          '    }\n' +
          '\n' +
          '}',
      consoleText: 'User(id=1, name=Jone, age=18, email=test1@baomidou.com)\n' +
          'User(id=2, name=Jack, age=20, email=test2@baomidou.com)\n' +
          'User(id=3, name=Tom, age=28, email=test3@baomidou.com)\n' +
          'User(id=4, name=Sandy, age=21, email=test4@baomidou.com)\n' +
          'User(id=5, name=Billie, age=24, email=test5@baomidou.com)'
    }
  }
}
</script>

<style scoped lang="less">
.text{
  margin-top: 14px;
  color: #215d42;
}
.title{
  color: #004050;
  font-size: 22px;
  font-weight: bold;
}
.divider{
  margin: 4px 0;
}
.alert{
  margin-top: 17px;
  .alert-title{
    color: #215d42;
    font-weight: bold;
  }
  .alert-description{
    color: #215d42;
  }
}
.out{
  margin-top: 30px;
}
.codeDisplay{
  margin-top: 14px;
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