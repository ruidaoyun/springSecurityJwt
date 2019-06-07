package com.belle.springsecurityjwt.test;

import com.belle.springsecurityjwt.utils.HttpClientUtil;
import com.sun.net.httpserver.Authenticator;
import org.apache.commons.httpclient.NameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTest {
    public static void main(String[] args) {
        /*List<NameValuePair> nameValuePairs = new ArrayList<> ();
        nameValuePairs.add (new NameValuePair ("description","hello"));
        nameValuePairs.add (new NameValuePair ("detail","world"));
        nameValuePairs.add (new NameValuePair ("id","98a688d15c1e47f0bfeadaf7291d383f"));
        nameValuePairs.add (new NameValuePair ("piclist","[{\"path\":\"/hello/world\"}]"));
        NameValuePair[] nameValuePairArr = new NameValuePair[nameValuePairs.size ()];
        NameValuePair[] nameValuePairs1=nameValuePairs.toArray (nameValuePairArr);
        Map<String, String> map=new HashMap<> ();
        System.out.println (HttpClientUtil.doPost ("https://ty-txw.belle.net.cn/suxuntest/operationtask/post_uploadtask", nameValuePairs1, null));*/
        List<NameValuePair> nameValuePairs = new ArrayList<> ();
        nameValuePairs.add (new NameValuePair ("app_id","1124"));
        nameValuePairs.add (new NameValuePair ("user_ids","[\"2083895\"]"));
        nameValuePairs.add (new NameValuePair ("message","测试"));
        nameValuePairs.add (new NameValuePair ("content","msgType为11无链接"));
        nameValuePairs.add (new NameValuePair ("msg_type","11"));
        nameValuePairs.add (new NameValuePair ("http_url","https://www.baidu.com"));
        nameValuePairs.add (new NameValuePair ("source","hh_topsports"));
        nameValuePairs.add (new NameValuePair ("app_key","MGVlYTIwYjhiZTkwNGNkZTBlYmFkZTM2"));
        NameValuePair[] nameValuePairArr = new NameValuePair[nameValuePairs.size ()];
        nameValuePairs.toArray (nameValuePairArr);
        Map<String, String> map=new HashMap<> ();
        map.put ("token","195e35722a7de48fd78b752880ab9e3f");
        map.put ("bundle","topsports");
        String result=HttpClientUtil.doPost ("https://dsp.topsports.com.cn:8443/api/sky_server_data_app/push/hh_push_im", nameValuePairArr, map);
        JSONObject jsonObject=new JSONObject (result);
        if ((int)jsonObject.get ("error_code")==0){
            System.out.println ("推送成功！");
        }

    }
}
