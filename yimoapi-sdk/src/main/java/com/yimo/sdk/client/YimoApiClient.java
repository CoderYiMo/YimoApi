package com.yimo.sdk.client;

import cn.hutool.core.util.RandomUtil;
import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static com.yimo.sdk.utils.SignUtils.genSign;

/**
 * @Author: 刘呈
 * @Date: 2023/02/23/23:28
 * @Description:
 */
public class YimoApiClient {
    private static final String GATEWAY_HOST = "http://localhost:9000";

    private String accessKey;

    private String secretKey;

    public YimoApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String test(){
        String url = GATEWAY_HOST+"/api/test";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String testSK(String info){
        String url = GATEWAY_HOST+"/api/testSK";
        Map<String, String> headerMap = getHeaderMap(info);
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder().addQueryParameter("info",info);
        Request request = new Request.Builder().url(builder.build()).headers(Headers.of(headerMap)).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> getHeaderMap(String body) {
        String encodeBody;
        try {
            encodeBody = URLEncoder.encode(body, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", encodeBody);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(encodeBody, secretKey));
        return hashMap;
    }


}
