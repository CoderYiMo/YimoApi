package com.yimo.use;

import com.yimo.sdk.client.YimoApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: 刘呈
 * @Date: 2023/02/24/0:36
 * @Description:
 */
@SpringBootTest
public class ApiTest {
    @Resource
    YimoApiClient yimoApiClient;

    @Test
    void test001(){
        String test = yimoApiClient.test();
        System.out.println(test);
    }

    @Test
    void test002(){
        yimoApiClient.testSK("hjkerfhedhbrfgejk");
    }
}
