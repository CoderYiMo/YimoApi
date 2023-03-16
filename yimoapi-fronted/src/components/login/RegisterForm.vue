<template>
  <div class="title">
    <div class="title1">壹默接口-API开放平台</div>
    <div class="title2">注册你的账号</div>
  </div>
  <div class="demo-register">
    <Login ref="form" @on-submit="handleSubmit">
      <UserName name="userAccount" placeholder="请输入账号,至少4位" :rules="accountRules"/>
      <Poptip trigger="focus" placement="right" width="240">
        <Password name="password" :rules="passwordRules" placeholder="至少8位密码，区分大小写" @on-change="handleChangePassword" style="width: 400px"/>
        <template #content>
          <div class="demo-register-tip">
            <div class="demo-register-tip-title" :class="passwordTip.class">
              强度：{{ passwordTip.strong }}
            </div>
            <Progress :percent="passwordTip.percent" hide-info :stroke-width="6" :stroke-color="passwordTip.color" />
            <div class="demo-register-tip-desc">
              请至少输入 8 个字符。请不要使用容易被猜到的密码。
            </div>
          </div>
        </template>
      </Poptip>
      <Password name="passwordConfirm" :rules="passwordConfirmRule" placeholder="确认密码" />
      <Submit>注册</Submit>
    </Login>
    <Button type="info" class="regBtn" @click="goToLogin">已有账号？去登录</Button>
  </div>
</template>

<script>
import router from "../../router";
import register from "../../api/register";

export default {
  data () {
    // 证规则变量是处在data的return外面
    //rule表示要验证的规则,value表示输入值,callback回调
    const validatePassCheck = (rule, value, callback) => {
      if (value !== this.$refs.form.formValidate.password) {
        callback(new Error('两次输入的密码不匹配！'));
      } else {
        callback();
      }
    };

    return {
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
      passwordConfirmRule: [
        {
          required: true, message: '确认密码不能为空！', trigger: 'change'
        },
        { validator: validatePassCheck, trigger: 'change' }//validator绑定验证规则变量
      ],
      // 密码长度，在密码强度提示时作为判断依据
      passwordLen: 0
    }
  },
  computed: {
    // 密码强度提示文案等
    passwordTip () {
      let strong = '强';
      let className = 'strong';
      let percent = this.passwordLen > 10 ? 10 : this.passwordLen;
      let color = '#19be6b';

      if (this.passwordLen < 6) {
        strong = '太短';
        className = 'low';
        color = '#ed4014';
      } else if (this.passwordLen < 10) {
        strong = '中';
        className = 'medium';
        color = '#ff9900';
      }

      return {
        strong,
        class: 'demo-register-tip-' + this.passwordLen < 6 ? 'low' : (this.passwordLen < 10 ? 'medium' : 'strong'),
        percent: percent * 10,
        color
      }
    }
  },
  methods: {
    handleChangePassword (val) {
      this.passwordLen = val.length;
    },
    async handleSubmit (valid, { userAccount, password }) {
      // if (valid) {
      //   this.$Modal.info({
      //     title: '输入的内容如下：',
      //     content: 'userAccount: ' + userAccount + ' | password: ' + password
      //   });
      // }
      if(valid){
        const res = await register(userAccount,password,password)
        // console.log(res)
        if(res.data.code !== 200)this.$Message.error(res.data.message);
        else this.$Message.success('注册成功');
      }
    },
    goToLogin() {
      router.replace({path: '/login'})
    }
  }
}
</script>

<style scoped lang="less">
//!important使属性值有最高优先级
.demo-register{
  width: 400px;
  margin: 0 auto !important;
}
.demo-register .ivu-poptip, .demo-register .ivu-poptip-rel {
  display: block;
}
.demo-register-tip{
  text-align: left;
}
//.demo-register-tip-low{
//  color: #ed4014 ;
//}
//.demo-register-tip-medium{
//  color: #ff9900 ;
//}
//.demo-register-tip-strong{
//  color: #19be6b ;
//}
.demo-register-tip-title{
  font-size: 14px;
}
.demo-register-tip-desc{
  white-space: initial;
  font-size: 14px;
  margin-top: 6px;
}
.title {
  /*border: 1px solid #000;*/
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
</style>