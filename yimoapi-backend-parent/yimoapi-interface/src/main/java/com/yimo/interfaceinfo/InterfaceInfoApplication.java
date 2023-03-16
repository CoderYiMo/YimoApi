package com.yimo.interfaceinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/15:42
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.yimo.client")
@EnableDiscoveryClient
public class InterfaceInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterfaceInfoApplication.class,args);
    }
}
