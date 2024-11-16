package com.dukz.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * file工具类
 *
 * @ClassName FileUtils
 * @Author dukz
 * @Date 2022/5/18
 * @Version 1.0
 */
public class FileUtils {

    private static List<File> fileList = new ArrayList<>();

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

    /**
     * 根据扩展名，过滤文件
     *
     * @param file
     * @param extensions
     * @param isDeep
     * @return
     */
    public static Collection<File> listFiles(File file, String[] extensions, boolean isDeep) {

        if (!file.exists()) {
            System.out.println("路径不存在:" + file);
        }

        listFiles(file, extensions);
        return fileList;

    }


    /**
     * 根据文件扩展名列表，过滤出指定扩展名的所有文件（包含子目录下的）
     *
     * @param file
     * @param extensions
     */
    private static void listFiles(File file, String[] extensions) {
        File[] fs = file.listFiles();

        for (File f : fs) {
            if (f.isDirectory()) {
                listFiles(f, extensions);
            }
            if (f.isFile()) {
                for (String extension : extensions) {
                    if (f.toString().endsWith(extension)) {
                        fileList.add(f);
                    }
                }
            }
        }
    }
}
