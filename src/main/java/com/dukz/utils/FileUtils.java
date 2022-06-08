package com.dukz.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * file工具类
 *
 * @ClassName FileUtils
 * @Author dukz
 * @Date 2022/5/18
 * @Version 1.0
 */
public class FileUtils {

    /**
     * 读取文件，返回字符串
     * @param fileName
     * @return
     */
    public static String readFileStr(String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"))){
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = fileReader.readLine()) != null){
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
