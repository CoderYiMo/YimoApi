package com.yimo.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yimo.common.model.entity.User;
import com.yimo.user.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author LiuCheng
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-02-23 13:49:38
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param response
     * @return token
     */
    Boolean userLogin(String userAccount, String userPassword, HttpServletResponse response);

    /**
     * 检查用户是否为管理员
     * @param token 用户token
     * @return bool
     */
    Boolean isAdmin(String token);

    /**
     * 获取当前登录用户
     * @param token 用户token
     * @return UserVO
     */
    UserVO getLoginUser(String token);
}
