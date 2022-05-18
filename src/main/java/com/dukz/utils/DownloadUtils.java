package com.dukz.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtils {

    /**
     * 下载图片，并按照指定的路径存储
     * @param filePath
     */
    public static void makeImage( String filePath, String fileName) throws IOException {
        // 网络请求所需变量
        //先将图片从url下载到服务器的D:/upload/
        File imageFile = new File("F:/download/"+fileName);
        InputStream inStream = null;
        //创建输出流
        FileOutputStream foutStream = new FileOutputStream(imageFile);
        try {
            //new一个URL对象
            URL url = new URL(filePath);
            //打开链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            inStream = conn.getInputStream();

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while( (len=inStream.read(buffer)) != -1 ){
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            byte []data=outStream.toByteArray();
            foutStream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭输出流
            foutStream.close();
            inStream.close();
        }
    }
}
