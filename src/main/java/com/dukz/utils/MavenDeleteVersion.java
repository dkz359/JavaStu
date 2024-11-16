package com.dukz.utils;

import java.io.File;
import java.util.Collection;

public class MavenDeleteVersion {

    public static void main(String[] args) {

        //本地仓库地址
        String repoPath = "D:\\Devolopment\\maven\\RepMaven";
        //需要删除的文件后缀
        String[] extensions = new String[]{
                "lastUpdated",
                "properties",
                "repositories"
        };
        //获取所有文件进行删除
        Collection<File> listFiles = FileUtils.listFiles(new File(repoPath), extensions, true);
        for (File file : listFiles) {
            System.out.println(file);
            file.delete();
        }
    }
}
