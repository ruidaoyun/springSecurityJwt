package com.belle.springsecurityjwt.spider;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *添加cookie模拟登录
 */
public class HttpClientDemo3 {
    public static void main(String[] args) {
        CloseableHttpClient httpClient=HttpClients.createDefault ();

        HttpGet httpGet=new HttpGet ("https://www.baidu.com");


    }
}
