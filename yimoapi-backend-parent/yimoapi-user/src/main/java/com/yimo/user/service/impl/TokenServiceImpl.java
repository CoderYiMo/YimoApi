package com.yimo.user.service.impl;


import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yimo.common.base.ErrorCode;
import com.yimo.common.constant.Time;
import com.yimo.common.exception.BusinessException;
import com.yimo.common.model.entity.User;
import com.yimo.common.util.AESUtil;
import com.yimo.user.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 刘呈
 * @Date: 2023/02/23/18:22
 * @Description:
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    private static final String secret = "yimo666";
    private static final String aesKey = "yimo999";

    @Override
    public String grant(User user) {
        HashMap<String, Object> infoMap = new HashMap<>();
        infoMap.put("userName", user.getUserName());
        infoMap.put("userAccount", user.getUserAccount());
        infoMap.put("userRole",user.getUserRole());
        infoMap.put("user_avatar",user.getUserAvatar());
//        过期时间设置为3小时
        infoMap.put("expireTime",System.currentTimeMillis() + Time.ONE_HOUR.getTime() * 3);
//        生成token
        String token = JWT.create().withClaim("userInfo", infoMap).sign(Algorithm.HMAC256(secret));
//        token加密
        String encrypt = AESUtil.encrypt(token, aesKey);
        return encrypt;
    }

    @Override
    public User validateAndGetUserInfo(String token) {
//        token解密
        String decryptToken = AESUtil.decrypt(token, aesKey);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        try{
            if(StrUtil.isBlank(decryptToken))throw new BusinessException(ErrorCode.JWT_ERROR,"token解密出错");
            jwtVerifier.verify(decryptToken);
            Map<String, Object> userInfo = JWT.decode(decryptToken).getClaim("userInfo").asMap();
            Date expireTime = new Date((Long) userInfo.get("expireTime"));
            if (new Date(System.currentTimeMillis()).after(expireTime)) throw new BusinessException(ErrorCode.JWT_EXPIRE_ERROR);;
            User user = new User();
            user.setUserName((String) userInfo.get("userName"));
            user.setUserAccount((String) userInfo.get("userAccount"));
            user.setUserRole((String) userInfo.get("userRole"));
            user.setUserAvatar((String) userInfo.get("user_avatar"));
            return user;
        }catch (JWTVerificationException e) {
            log.info("jwt验证失败"+e.getMessage());
            throw new BusinessException(ErrorCode.JWT_ERROR);
        }
    }
}
