import http from "../plugins/axios";
import {userInfoStore} from "../store/piniaStore";

// const store = userInfoStore()

function getMenu(role) {
    if(role === "user"){
        return http.get(
            '/menu/user'
        )
    }
    else{
        return http.get(
            '/menu/admin'
        )
    }

}

function getUserBaseInfo(token) {
    return http.get(
        '/user/get/login',
        {
            headers: {'user_token' : token}
        }
    )
}
export {getMenu,getUserBaseInfo}