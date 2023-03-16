package com.yimo.server.controller;

import com.yimo.client.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/10:59
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Resource
    UserClient userClient;
    @GetMapping("/test")
    public String test(){
        return "当你看到这一条消息就意味着你成功调用了该接口，恭喜你！";
    }

    @GetMapping("/testSK")
    public String testSK(@RequestParam String info, HttpServletRequest request){
        Boolean aBoolean = userClient.validAKSK(request.getHeader("accessKey"), request.getHeader("body"), request.getHeader("sign"));
        if(aBoolean) System.out.println("验证aksk成功");
        try {
            System.out.println(URLDecoder.decode(request.getHeader("body"),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
