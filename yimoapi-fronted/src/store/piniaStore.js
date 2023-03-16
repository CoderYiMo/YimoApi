import { defineStore } from 'pinia'

export const userInfoStore = defineStore('userInfo',{
    state:() => ({
        userToken: null,
        userMenu: null,
        userBaseInfo: {
            userName: '',
            userAccount: '',
            userAvatar: '',
            gender: '',
            userRole: ''
        }
    }),
    getters: {

    },
    actions: {

    },
    persist: {
        enabled: true,
        strategies: {
            key: 'user',
            storage: localStorage
        }
    }
})