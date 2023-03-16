package com.yimo.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/20:52
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.yimo.client")
public class InvokeApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvokeApplication.class,args);
    }
}
