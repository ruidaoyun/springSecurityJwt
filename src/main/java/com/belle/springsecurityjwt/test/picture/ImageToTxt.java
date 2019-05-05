package com.belle.springsecurityjwt.test.picture;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.org.jvnet.staxex.Base64EncoderStream;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * @author: rui.dy
 * @date: 2019/4/1
 * @description:
 */
public class ImageToTxt {

    static String base = "@#&$%*o!;.";

    public static void ImageToGray(String sourcePath) throws Exception {
        System.out.println (sourcePath);
        BufferedImage img=ImageIO.read (new File (sourcePath));
        int width=img.getWidth ();
        int height=img.getHeight ();
        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                int rgb=img.getRGB (i, j);
                img.setRGB (i,j,grayRGB (Integer.toHexString (rgb)));
            }
        }
        String destPath = sourcePath.substring (0,sourcePath.lastIndexOf ("."))
                +"-gray"
                +sourcePath.substring (sourcePath.lastIndexOf ("."));
        System.out.println (destPath);
        ImageIO.write (img,"jpg",new File (destPath));
    }

    public static void ImageToTxt(String sourcePath) throws IOException {
        BufferedImage img=ImageIO.read (new File (sourcePath));
        int width=img.getWidth ();
        int height=img.getHeight ();
        int minX=img.getMinX ();
        int minY=img.getMinY ();
        String text = "";
        for (int i=0; i < height; i++) {
            for (int j=0; j < width; j++) {
                String pixel=Integer.toHexString (img.getRGB (j, i));
                int r=Integer.parseInt (pixel.substring (2, 4), 16);
                int g=Integer.parseInt (pixel.substring (4, 6), 16);
                int b=Integer.parseInt (pixel.substring (6, 8), 16);
                float gray = r*0.299f + g*0.578f + b*0.114f;
                int index=Math.round (gray * (base.length () + 1) / 255);
                text += index>=base.length ()?" ":String.valueOf (base.charAt (index));
            }
            text += "\r\n";
        }
        String destPath = sourcePath.substring (0,sourcePath.lastIndexOf ("."))
                +".txt";
        System.out.println (destPath);
        try {
            writeTxtFile(text,destPath);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public static void ImageToCharImage(String sourcePath) throws IOException{
        BufferedImage img=ImageIO.read (new File (sourcePath));
        int width=img.getWidth ();
        int height=img.getHeight ();
        int speed = 7;
        BufferedImage bi=new BufferedImage (width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics=createGraphics (bi, width, height, speed);
        for (int i=0; i < height; i++) {
            for (int j=0; j < width; j++) {
                String pixel=Integer.toHexString (img.getRGB (j, i));
                int r=Integer.parseInt (pixel.substring (2, 4), 16);
                int g=Integer.parseInt (pixel.substring (4, 6), 16);
                int b=Integer.parseInt (pixel.substring (6, 8), 16);
                float gray = r*0.299f + g*0.578f + b*0.114f;
                int index=Math.round (gray * (base.length () + 1) / 255);
                String c = index>=base.length ()?" ":String.valueOf (base.charAt (index));
                graphics.drawString (String.valueOf (c),j,i);
            }
        }
        graphics.dispose ();
        String destPath = sourcePath.substring (0,sourcePath.lastIndexOf ("."))
                +"-char"
                +sourcePath.substring (sourcePath.lastIndexOf ("."));
        System.out.println (destPath);
        FileOutputStream fos = null;
        try {
            fos=new FileOutputStream (destPath);
            JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder (fos);
            BASE64Encoder base64Encoder=new BASE64Encoder ();
            encoder.encode (bi);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } finally {
            fos.close ();
        }
    }

    public static void gifToCharGif(String sourcePath) throws IOException{

    }

    private static int grayRGB(String argb){
        int r=Integer.parseInt (argb.substring (2, 4), 16);
        int g=Integer.parseInt (argb.substring (4, 6), 16);
        int b=Integer.parseInt (argb.substring (6, 8), 16);
        String average=Integer.toHexString ( new Double (r*0.299 + g*0.587 + b*0.114).intValue ());
        if (average.length ()==1){
            average = "0"+average;
        }
        return Integer.parseInt (average+average+average,16);
    }

    private static void writeTxtFile(ArrayList<String> list,String destPath) {
        PrintStream ps=null;
        try {
            ps=new PrintStream (new FileOutputStream (new File (destPath)));
            for (String line : list) {
                ps.append (line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } finally {
            ps.close ();
        }
    }

    private static Graphics createGraphics(BufferedImage image, int width,
                                           int height, int size) {
        Graphics g = image.createGraphics();
        g.setColor(null); // 设置背景色
        g.fillRect(0, 0, width, height);// 绘制背景
        g.setColor(Color.BLACK); // 设置前景色
        g.setFont(new Font("微软雅黑", Font.PLAIN, size)); // 设置字体
        return g;
    }

    private static boolean writeTxtFile(String imageStr, String txtPath) throws Exception{
        // 先读取原有文件内容，然后进行写入操作
        boolean flag = false;
        String filein = imageStr;
        String temp = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(txtPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
            }
            buf.append(filein);
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            flag = true;
        } catch (IOException e) {
            System.out.println("文件保存失败"+e.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        try {
            //ImageToGray ("C:\\Users\\14184\\Desktop\\photo\\1.jpg");
            ImageToTxt ("C:\\Users\\14184\\Desktop\\photo\\test.jpg");
            //ImageToCharImage ("C:\\Users\\14184\\Desktop\\photo\\test.jpg");
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
