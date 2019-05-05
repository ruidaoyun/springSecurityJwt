package com.belle.springsecurityjwt.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.*;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.commons.httpclient.methods.GetMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;

public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String doPost(String url, NameValuePair[] nameValuePairs, Map<String, String> headParams) {
        Date startTime = new Date();

        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        PostMethod method = new UTF8PostMethod(url);

        if (headParams != null) {
            Set<String> keySet = headParams.keySet();

            for (String key : keySet) {
                if ("HOST".equals(key.toUpperCase())) {
                    method.getParams().setVirtualHost(headParams.get(key));
                } else {
                    method.setRequestHeader(key, headParams.get(key));
                }
            }
        }


        method.setRequestBody(nameValuePairs);
        InputStream responseBodyStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                responseBodyStream = method.getResponseBodyAsStream();
                streamReader = new InputStreamReader(responseBodyStream, "utf-8");
                reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
        } catch (Exception e) {
            logger.error("", e);
            String message = String.format("{\"error_code\":-1,\"message\":\"网络请求异常\"}");
            return message;
        } finally {
            try {
                if (responseBodyStream != null) {
                    responseBodyStream.close();
                }
                if (streamReader != null) {
                    streamReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                logger.error("", e);
                String message = String.format("{\"error_code\":-1,\"message\":\"网络请求异常\"}");
                return message;

            }
            method.releaseConnection();
        }
        Date endTime = new Date();
        long executeTime = endTime.getTime() - startTime.getTime();


        logger.info("外部接口调用时间：" + executeTime + "ms");
        logger.info("输入：{ <URL: {}> , <Method: doPost> , <Http Header: {}> , <Query Data: {}> }",url,headParams,nameValuePairs);
        logger.info("输出：{" + response.toString() + "}");
        return response.toString();
    }

    public static String doGet(String url, Map<String, String> headParams) {
        Date startTime = new Date();
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        StringBuffer log = new StringBuffer("输入：{ <URL: " + url + "> , <Method: doGet> , <Http Header: ");
        if (headParams != null) {
            Set<String> keySet = headParams.keySet();
            for (String key : keySet) {
                if ("HOST".equals(key.toUpperCase())) {
                    method.getParams().setVirtualHost(headParams.get(key));
                } else {
                    method.setRequestHeader(key, headParams.get(key));
                }
            }

        }
        log.append("> }");

        InputStream responseBodyStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                responseBodyStream = method.getResponseBodyAsStream();
                streamReader = new InputStreamReader(responseBodyStream, "utf-8");
                reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } else {
                responseBodyStream = method.getResponseBodyAsStream();
                streamReader = new InputStreamReader(responseBodyStream, "utf-8");
                reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            logger.error("", e);
            String message = String.format("{\"error_code\":-1,\"message\":\"网络请求异常\"}");
            return message;
        } finally {
            try {
                if (responseBodyStream != null) {
                    responseBodyStream.close();
                }
                if (streamReader != null) {
                    streamReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                // logger.error("执行HTTP Get请求" + url + "时，发生异常，关闭流异常！", e);

                logger.error("", e);
                String message = String.format("{\"error_code\":-1,\"message\":\"网络请求异常\"}");
                return message;

            }
            method.releaseConnection();
        }

        Date endTime = new Date();
        long executeTime = endTime.getTime() - startTime.getTime();


        logger.info("外部接口调用时间：" + executeTime + "ms");
        logger.info("输入：{ <URL: {}> , <Method: doGet> , <Http Header: {}> }",url,headParams);
        logger.info("输出：{" + response.toString() + "}");
        return response.toString();
    }

    public static class UTF8PostMethod extends PostMethod {
        public UTF8PostMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            //return super.getRequestCharSet();
            return "UTF-8";
        }
    }
}
