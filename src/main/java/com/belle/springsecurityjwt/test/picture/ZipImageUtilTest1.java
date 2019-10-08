package com.belle.springsecurityjwt.test.picture;

import java.awt.*;

/**
 * @author: rui.dy
 * @date: 2019/3/30
 * @description:
 */
public class ZipImageUtilTest1 {
    public static void main(String[] args) {
        ZipImageUtil zip=new ZipImageUtil("C:\\Users\\14184\\Desktop\\desktop\\photo\\","a.gif","C:\\Users\\14184\\Desktop\\desktop\\photo\\","a-50.gif",false);
        zip.setOutPutFileWidth(1000);
        zip.setOutPutFileHeight(1000);

        Image image=null;
        try {
            image=zip.getSourceImage();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        long size=zip.getPicSize("d:\\1.jpg");
        System.out.println("处理前的图片大小 width:"+image.getWidth(null));
        System.out.println("处理前的图片大小 height:"+image.getHeight(null));
        System.out.println("处理前的图片容量:"+ size +" bit");

        zip.compressImage();
    }
}
