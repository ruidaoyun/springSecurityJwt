package com.belle.springsecurityjwt.test;

import com.belle.springsecurityjwt.utils.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpTest3 {
    public static void main(String[] args) {
        /*nameValuePairs.add (new NameValuePair ("description","hello"));
        nameValuePairs.add (new NameValuePair ("detail","world"));
        nameValuePairs.add (new NameValuePair ("id","98a688d15c1e47f0bfeadaf7291d383f"));
        nameValuePairs.add (new NameValuePair ("piclist","[{\"path\":\"/hello/world\"}]"));
        NameValuePair[] nameValuePairArr = new NameValuePair[nameValuePairs.size ()];
        NameValuePair[] nameValuePairs1=nameValuePairs.toArray (nameValuePairArr);
        Map<String, String> map=new HashMap<> ();
        System.out.println (HttpClientUtil.doPost ("https://ty-txw.belle.net.cn/suxuntest/operationtask/post_uploadtask", nameValuePairs1, null));*/

        CloseableHttpClient httpClient=HttpClients.createDefault ();
        HttpPost httpPost=new HttpPost ("https://ty-txw.belle.net.cn/suxuntest/operationtask/post_uploadtask");
        /*ArrayList<NameValuePair> nameValuePairs=new ArrayList<> ();
        nameValuePairs.add (new BasicNameValuePair ("description","hello"));
        nameValuePairs.add (new BasicNameValuePair ("detail","world"));
        nameValuePairs.add (new BasicNameValuePair ("id","98a688d15c1e47f0bfeadaf7291d383f"));
        nameValuePairs.add (new BasicNameValuePair ("piclist","[{\"path\":\"/hello/world\"}]"));*/
        JSONObject json=new JSONObject ();
        HashMap<String, Object> map=new HashMap<> ();
        ArrayList<HashMap<String, Object>> list=new ArrayList<> ();
        json.put ("description","hello");
        json.put ("detail","world");
        json.put ("id","98a688d15c1e47f0bfeadaf7291d383f");
        map.put ("path","/hello/world");
        list.add (map);
        json.put ("piclist",list);
        try {
            httpPost.setHeader ("Content-Type","application/json");
            httpPost.setEntity (new StringEntity (json.toString (),"utf-8"));
            //httpPost.setEntity (new UrlEncodedFormEntity (nameValuePairs,"UTF-8"));
            CloseableHttpResponse response=httpClient.execute (httpPost);
            String entity=EntityUtils.toString (response.getEntity (), "UTF-8");
            System.out.println (entity);
            JSONObject jsonObject=new JSONObject (entity);
            System.out.println (jsonObject.get ("code"));
            System.out.println (jsonObject.get ("msg"));
            System.out.println (jsonObject.get ("data"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        } catch (ClientProtocolException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            httpPost.abort ();
        }
    }
}
