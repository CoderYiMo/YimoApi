import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/login/Login.vue'
import RegisterForm from "../components/login/RegisterForm.vue";
import LoginForm from "../components/login/LoginForm.vue";
import Main from "../views/main/Main.vue";
import Install from "../components/main/Install.vue";
import {userInfoStore} from "../store/piniaStore";
import Introduction from "../components/main/Introduction.vue";
import QuickStart from "../components/main/QuickStart.vue";
import QandA from "../components/main/QandA.vue";
import Interface from "../components/main/Interface.vue";
import PayInterface from "../components/main/PayInterface.vue";

let store = null
const routes = [
  {
    path: '/',
    component: Login,
    children: [
      {
        path: 'login',
        name: 'loginForm',
        component: LoginForm,
      },
      {
        path: 'register',
        name: 'registerForm',
        component: RegisterForm,
      }
    ]
  },
  {
    path: '/home',
    redirect:'/home/introduction',
    component: Main,
    children: [{
      path: 'install',
      name: 'install',
      component: Install
    },
      {
        path: 'introduction',
        name: 'introduction',
        component: Introduction
      },
      {
        path: 'quickstart',
        name: 'quickstart',
        component: QuickStart
      },
      {
        path: 'qa',
        name: 'qa',
        component: QandA
      },
      {
        path: 'freeapi',
        name: 'freeapi',
        component: Interface
      },
      {
        path: 'payapi',
        name: 'payapi',
        component: PayInterface
      }]
  }
]

const router = createRouter({
  routes,
  history: createWebHistory(),
  scrollBehavior() {
    return { top: 0 }
  }
})

router.beforeEach((to,from,next)=>{
  if(store === null)store = userInfoStore()
  if(to.path === '/login' || to.path === '/register')
    next()
  else if(store.userToken === null){
    next({
      path: '/login'
    })
  }
  else{
    next()
  }
})

export default router
