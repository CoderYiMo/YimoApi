package com.yimo.user.service;


/**
 * @Author: 刘呈
 * @Date: 2023/02/24/11:27
 * @Description:
 */
public interface AKSKService {
    /**
     *
     * @param accessKey ak
     * @param body 用户传递的信息
     * @param sign body和sk通过md5加密而成的签名
     * @return bool ak和sk是否有效
     */
    Boolean validAKSK(String accessKey,String body,String sign);
}
