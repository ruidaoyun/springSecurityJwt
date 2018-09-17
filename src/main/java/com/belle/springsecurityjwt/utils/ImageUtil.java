package com.belle.springsecurityjwt.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class ImageUtil {

     /**
     * 描述：将图片文件进行base64编码
     */
    public static String encodeImgageToBase64(File
                                                      imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            String suffixName=imageFile.getName ().substring (imageFile.getName ().lastIndexOf (".") + 1);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, suffixName, outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
    }

    /**
     * 描述：将base64图片解码并保存
     */
    public static File decodeBase64ToImage(String base64, String path, String imgName) {
        BASE64Decoder decoder = new BASE64Decoder();
        File file=null;
        try {
            file=new File(path +"/"+ imgName);
            FileOutputStream write = new FileOutputStream(file);
            String replace=base64.substring (base64.indexOf (",")+1);
            byte[] decoderBytes = decoder.decodeBuffer(replace);
            write.write(decoderBytes);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /*public static String encodeImgageToBase64(URL imageUrl) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        ByteArrayOutputStream outputStream = null;
        try {
            String suffixName=imageFile.getName ().substring (imageFile.getName ().lastIndexOf (".") + 1);
            BufferedImage bufferedImage = ImageIO.read(imageUrl);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, suffixName, outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
    }*/

}
