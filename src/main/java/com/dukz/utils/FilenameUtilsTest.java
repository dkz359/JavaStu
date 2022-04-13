package com.dukz.utils;

import org.apache.commons.io.FilenameUtils;

/**
 * @author dukezheng
 * @ClassName FilenameUtilsTest
 * @Description TODO
 * @date 2021/1/5 16:28
 * @Version 1.0
 */
public class FilenameUtilsTest {
    public static void main(String[] args) {
        // String filename = "D:\\workspace\\HYPROJ2\\40_source\\80_数字法院\\np-fy-spxt\\java\\target\\spxt\\WEB-INF\\lib\\aaa.txt";
        String filename = "http://localhost:8081/spxt/attached/20210715190113_927.png";
        String baseName = FilenameUtils.getBaseName(filename);
        System.out.println(baseName);
        String name = FilenameUtils.getName(filename);
        System.out.println(name);
        String prefix = FilenameUtils.getPrefix(filename);
        System.out.println(prefix);
        String extension = FilenameUtils.getExtension(filename);
        System.out.println(extension);
    }
}
