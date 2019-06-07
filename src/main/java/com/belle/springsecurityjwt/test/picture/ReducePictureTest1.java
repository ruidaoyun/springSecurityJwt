package com.belle.springsecurityjwt.test.picture;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * @author: rui.dy
 * @date: 2019/3/29
 * @description: 压缩图片
 * @blog: https://www.cnblogs.com/linkstar/p/7412012.html
 */
public class ReducePictureTest1 {
    public static void main(String[] args) {
        //其中的scale是可以指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽。
        //而outputQuality是图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差。
        try {
            Thumbnails.of ("C:\\Users\\14184\\Desktop\\desktop\\photo\\a.gif")
                    .scale (1f)
                    .outputQuality (0.5f)
                    .toFile ("C:\\Users\\14184\\Desktop\\desktop\\photo\\a-50.gif");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
