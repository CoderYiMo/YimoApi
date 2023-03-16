package com.yimo.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yimo.common.base.ErrorCode;
import com.yimo.common.exception.BusinessException;
import com.yimo.common.model.entity.User;
import com.yimo.common.util.SignUtils;
import com.yimo.user.service.AKSKService;
import com.yimo.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/12:37
 * @Description:
 */
@Service
public class AKSKServiceImpl implements AKSKService {
    @Resource
    UserService userService;
    @Override
    public Boolean validAKSK(String accessKey,String body,String sign) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("access_key",accessKey);
        User user = userService.getOne(userQueryWrapper);
//        非法AK
        if(user == null)throw new BusinessException(ErrorCode.NO_AUTH_ERROR,"ak未授权");
//        签名
        String newSign = SignUtils.genSign(body, user.getSecretKey());
        if(newSign.equals(sign))return true;
//        AK正确,SK错误
        else throw new BusinessException(ErrorCode.NO_AUTH_ERROR,"ak和sk匹配失败");
    }
}
