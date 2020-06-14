package com.df.drs.base.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yuan
 * @project drs
 * @description 发送http请求的工具类
 * @date 2020/5/27 9:44
 **/
public class HttpClientUtils {

    /**
     * 发送get请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String doGet(String url, Map<String, String> param) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回字符串
        String resultString = "";
        // 请求的响应
        CloseableHttpResponse response = null;

        try {
            // 创建uri
            URIBuilder uriBuilder = new URIBuilder(url);
            if (null != param) {
                for (String key : param.keySet()) {
                    uriBuilder.addParameter(key, param.get(key));
                }
            }
            URI uri = uriBuilder.build();

            // 创建http get请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断响应码是否是200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    /**
     * 发送post请求 参数为map
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url, Map<String,String> param) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回字符串
        String resultString = "";
        // 请求的响应
        CloseableHttpResponse response = null;
        // 创建http post请求
        HttpPost httpPost = new HttpPost(url);
        // 创建参数列表
        if (null != param) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key:param.keySet()) {
                paramList.add(new BasicNameValuePair(key,param.get(key)));
            }
            // 表单实体
            UrlEncodedFormEntity formEntity = null;
            try {
                formEntity = new UrlEncodedFormEntity(paramList);
                // 设置表单实体
                httpPost.setEntity(formEntity);
                // 执行请求
                response = httpClient.execute(httpPost);
                // 判断响应码是否是200
                if (response.getStatusLine().getStatusCode() == 200) {
                    resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != response) {
                        response.close();
                    }
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultString;
    }

    /**
     * 发送post请求 参数为json串
     * @param url
     * @param json
     * @return
     */
    public static String doPostJson(String url, String json) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回字符串
        String resultString = "";
        // 请求的响应
        CloseableHttpResponse response = null;
        // 创建http post请求
        HttpPost httpPost = new HttpPost(url);
        // string 实体
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        // 设置实体
        httpPost.setEntity(stringEntity);

        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            // 判断响应码是否是200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
}
