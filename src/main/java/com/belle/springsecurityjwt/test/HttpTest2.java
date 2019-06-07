package com.belle.springsecurityjwt.test;

import com.belle.springsecurityjwt.utils.HttpClientUtil;
import org.apache.commons.httpclient.NameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTest2 {
    public static void main(String[] args) {
        //System.out.println (HttpClientUtil.doGet ("https://ty-txw.belle.net.cn/suxuntest/operationhistory/get_knowledgeanswerlist?id=d5687ac04ae149bd880bbf856d48f65b", null));
        List<NameValuePair> nameValuePairs = new ArrayList<> ();
        nameValuePairs.add (new NameValuePair ("description","hello"));
        nameValuePairs.add (new NameValuePair ("detail","world"));
        nameValuePairs.add (new NameValuePair ("id","98a688d15c1e47f0bfeadaf7291d383f"));
        nameValuePairs.add (new NameValuePair ("piclist","[{\"path\":\"/hello/world\"}]"));
        NameValuePair[] nameValuePairArr = new NameValuePair[nameValuePairs.size ()];
        NameValuePair[] nameValuePairs1=nameValuePairs.toArray (nameValuePairArr);
        Map<String, String> map=new HashMap<> ();
        map.put ("Content-Type","application/json");
        System.out.println (HttpClientUtil.doPost ("https://ty-txw.belle.net.cn/suxuntest/operationtask/post_uploadtask", nameValuePairs1, map));

    }
}
