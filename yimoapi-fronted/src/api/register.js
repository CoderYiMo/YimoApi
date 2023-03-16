import http from "../plugins/axios";

function register( userAccount, password, checkPassword) {
    return http.post(
        '/user/register',
        {
            userAccount: userAccount,
            userPassword: password,
            checkPassword: checkPassword
        }
    )
}
export default register