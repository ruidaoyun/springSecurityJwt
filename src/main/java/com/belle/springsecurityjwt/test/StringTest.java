package com.belle.springsecurityjwt.test;

import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {

    /**
     * 截取#号中的图片地址
     * @param content
     * @return 字符串  例： “url1,url2,url3”
     */
    public static String getPicUrl(String content) {
        //			String text="jkj你好在的放到fj#url1##url2#fd放到akfdadf#url3#fd";
        int index = content.indexOf("#");
        String urls = "";
        int a = index;
        int b = -1;
        while (index != -1) {
            index = content.indexOf("#", index + 1);
            if (a == -1) {
                a = index;
            } else if (b == -1) {
                b = index;
                urls += content.substring(a + 1, b) + ",";
                a = -1;
                b = -1;
            }
        }
        if (!urls.equals("")) {
            urls = urls.substring(0, urls.length() - 1);
        }
        return urls;
    }

    private static void addPicUrl(ArrayList<Map> list){
        for (Map questionMap:list){
            String picName="";
                questionMap.put ("pic",null);
        }
    }

    //比较两个String集合的每个值是否相等
    private  static boolean compare(List<String> list1,List<String> list2){
        if (list1==null||list2==null) {
            return false;
        }
        if (list1.size ()!=list2.size ()){
            return false;
        }
        for (String s1:list1){
            if (!list2.contains (s1)){
                return false;
            }
        }
        for (String s2:list2){
            if (!list1.contains (s2)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       /* //System.out.println (getPicUrl ("hello#123456#,world#45678900#"));
        ArrayList<Map> maps=new ArrayList<> ();
        HashMap<String, Object> hashMap2=new HashMap<> ();
        HashMap<String, Object> hashMap1=new HashMap<> ();
        hashMap1.put ("hello","world");
        hashMap2.put ("world","hello");
        maps.add (hashMap1);
        maps.add (hashMap2);
        addPicUrl (maps);
        System.out.println (maps);*/
        List<String> list1=new ArrayList<> ();
        List<String> list2=new ArrayList<> ();
        list1.add ("a");
        list1.add ("b");
        list2.add ("b");
        list2.add ("a");
        System.out.println (compare (list1, list2));
    }
}
