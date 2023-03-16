<template>
  <div class="title">
    <div class="title1">壹默接口-API开放平台</div>
    <div class="title2">登录你的账号</div>
  </div>
  <div class="demo-login">
    <Login @on-submit="handleSubmit">
      <UserName name="username" placeholder="请输入账号,至少4位" :rules="accountRules"/>
      <Password name="password" placeholder="至少8位密码，区分大小写" :rules="passwordRules"/>
      <div class="captcha-group">
        <captcha-util :identifyCode="identifyCode" @click="refreshCode" class="captcha"></captcha-util>
        <Input prefix="ios-apps-outline" v-model="captchaInput" placeholder="请输入验证码" class="captcha-input" size="large" ></Input>
      </div>
      <div class="demo-auto-login">
        <Checkbox v-model="autoLogin" size="large">自动登录</Checkbox>
        <a>忘记密码</a>
      </div>
      <Submit />
    </Login>
    <Button type="info" class="regBtn" @click="goToRegister">还没有账号？去注册</Button>
  </div>
</template>

<script>
import router from "../../router";
import login from "../../api/login";
import {userInfoStore} from "../../store/piniaStore";
import CaptchaUtil from "../../utils/Captcha.vue";


export default {
  components: {CaptchaUtil},
  data () {
    return {
      identifyCode: '',
      captchaInput: '',
      identifyCodes: '1234567890abcdefjhijklinopqrsduvwxyz',//随机串内容
      bodyHeight: 0,
      autoLogin: false,
      accountRules:[{
        required: true, message: '账号不能为空！', trigger: 'change'
      },
        {
          required: true, message: '账号不能为空！', trigger: 'blur'
        },
        {
          min: 4,message: '账号不能少于4位！', trigger: 'change'
        },
        {
          min: 4,message: '账号不能少于4位！', trigger: 'blur'
        }],
      passwordRules:[{
        required: true, message: '密码不能为空！', trigger: 'change'
      },{
        required: true, message: '密码不能为空！', trigger: 'blur'
      },{
        min: 8,message: '密码不能少于8位！', trigger: 'change'
      },{
        min: 8,message: '密码不能少于8位！', trigger: 'blur'
      }],
    }
  },
  mounted() {
    // 初始化验证码
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
  },
  methods: {
    async handleSubmit (valid, { username, password, captcha }) {
      // 验证码验证
      if (this.captchaInput.toLowerCase() !== this.identifyCode.toLowerCase()) {
        this.$Message.error('请填写正确验证码')
        this.refreshCode()
        return
      }
      if (valid) {
        const res = await login(username,password)
        if(res.data.code !== 200){
          this.$Message.error('账号或密码错误！');
        }
        else{
          this.$Message.success('登录成功');
          // 通过状态库存储token
          const store = userInfoStore()
          store.$patch({
            userToken: res.headers.user_token
          })
          await router.replace('/home')
        }
      }
    },
    goToRegister() {
      router.replace({path: '/register'})
    },
    // 重置验证码
    refreshCode () {
      this.identifyCode = ''
      this.makeCode(this.identifyCodes, 4)
    },
    makeCode (o, l) {
      for (let i = 0; i < l; i++) {
        this.identifyCode += this.identifyCodes[this.randomNum(0, this.identifyCodes.length)]
      }
    },
    randomNum (min, max) {
      return Math.floor(Math.random() * (max - min) + min)
    }
  }
}
</script>

<style scoped lang="less">
.demo-login{
  width: 400px !important;
  margin: 0 auto;
}
.demo-auto-login{
  margin-top: 20px;
  margin-bottom: 24px;
  text-align: left;
  a{
    float: right;
  }
}
.title {
  //border: 1px solid #000;
  width: 400px;
  margin: 25vh auto 20px;

  .title1 {
    font-size: 30px;
  }

  .title2 {
    font-weight: bold;
    font-size: 20px;
  }
}
.regBtn{
  width: 400px;
  height: 40px;
  margin-top: 10px;
  font-size: 17px;
  line-height: 40px;
}
.captcha-group{
  display: flex;
  //border: 1px solid #000;
  .captcha{
    //border: 1px solid #000;
    height: 40px;
    width: 90px;
  }
  .captcha-input{
    //height: 40px;
    margin-left: 10px;
  }
}
</style>