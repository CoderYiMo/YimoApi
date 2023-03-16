package com.yimo.sdk.config;

import com.yimo.sdk.client.YimoApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 刘呈
 * @Date: 2023/02/23/23:26
 * @Description:
 */
@Configuration
@ConfigurationProperties("yimoapi.client")
@Data
public class YimoApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public YimoApiClient yimoApiClient(){
        return new YimoApiClient(accessKey,secretKey);
    }
}
