package com.yimo.client;


import com.yimo.common.base.BaseResponse;
import com.yimo.common.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/13:13
 * @Description:
 */
@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/user/validAKSK")
    public Boolean validAKSK(@RequestParam("accessKey") String accessKey, @RequestParam("body") String body, @RequestParam("sign") String sign);

    @GetMapping("/get/login")
    public BaseResponse<UserVO> getLoginUser(HttpServletRequest request);

    @GetMapping("/isAdmin")
    public Boolean isAdmin(HttpServletRequest request);

}
