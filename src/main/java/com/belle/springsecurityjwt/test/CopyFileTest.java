package com.belle.springsecurityjwt.test;

import java.io.*;

/**
 * 复制windows桌面下某文件夹下的doc文档到另一个文件夹
 */
public class CopyFileTest {
    private final static String DESKTOP = "C:\\Users\\14184\\DESKTOP";

    public static void main(String[] args) {
        loopPath (DESKTOP+"\\文档");
    }

    /**
     * 遍历并复制一个路径下的doc文件
     */
    private static void loopPath(String path){
        String[] pathList=new File (path).list ();
        //System.out.println (pathList.length);
        File destFolder=new File (DESKTOP + "\\docFiles");
        //如果目标文件夹不存在，那么建立文件夹
        if (!destFolder.exists ()){
            destFolder.mkdir ();
        }
        for (String file : pathList) {
            File pathFile=new File (path+"\\"+file);
            //如果是文件夹那么递归遍历，否则判断是不是doc文件
            if (pathFile.isDirectory ()) {
                loopPath (path+"\\"+file);

            }else {
                //跳过没有后缀名的文件
                if (pathFile.getName ().lastIndexOf (".")==-1){
                    continue;
                }
                //获取文件的后缀名
                String suffixName=pathFile.getName ().substring (pathFile.getName ().lastIndexOf (".")+1);
                //如果是doc文件，那么复制到目标路径下
                if ("doc".equals (suffixName)||"docx".equals (suffixName)){
                    System.out.println (pathFile.getName ());
                    //获取该文件的inputStream对象
                    FileInputStream fis=null;
                    FileOutputStream fos=null;
                    try {
                        fis=new FileInputStream (pathFile);
                        //写入路径
                        fos=new FileOutputStream (new File (DESKTOP + "\\docFiles\\" + pathFile.getName ()));
                        byte[] bytes=new byte[1024];
                        while ((fis.read (bytes))!=-1){
                            fos.write (bytes);
                        }
                        fos.flush ();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }finally {
                        try {
                            fos.close ();
                            fis.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }

                }
            }
        }
    }
}
