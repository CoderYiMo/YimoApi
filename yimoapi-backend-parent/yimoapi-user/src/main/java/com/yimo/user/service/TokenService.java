package com.yimo.user.service;

import com.yimo.common.model.entity.User;

/**
 * @Author: 刘呈
 * @Date: 2023/02/23/18:22
 * @Description:
 */
public interface TokenService {
    /**
     * 认证接口，返回token
     * @param user
     * @return
     */
    String grant(User user);

    /**
     * 验证接口，验证成功则返回用户信息
     * @param token
     * @return
     */
    User validateAndGetUserInfo(String token);
}
