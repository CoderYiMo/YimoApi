import http from "../plugins/axios";

 function login( username, password) {
    return http.post(
        '/user/login',
        {
            userAccount: username,
            userPassword: password
        }
    )
}
export default login