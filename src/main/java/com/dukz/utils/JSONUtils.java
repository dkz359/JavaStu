package com.dukz.utils;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class JSONUtils {

    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            BufferedReader fileReader = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();
            String str = null;
            while ((str = fileReader.readLine()) != null){
                sb.append(str);
            }
            fileReader.close();
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 将JSON转成insertSQL语句
     * @param lineJson
     * @param tableName
     * @return
     */
    public static String json2InsertSQL(JSONObject lineJson, String tableName){
        return json2InsertSQL(lineJson, tableName, "deleteField");
    }

    /**
     * 将JSON转成insertSQL语句
     * @param lineJson
     * @param tableName
     * @param identityField 忽略的字段
     * @return
     */
    public static String json2InsertSQL(JSONObject lineJson, String tableName, String identityField){
        //先转成 insert into tableName (若干字段) 形式
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(tableName)
                .append(" (");
        List<String> columns = new ArrayList<>();
        for (String key : lineJson.keySet()) {
            key = StringUtils.capitalize(key);
            if (identityField.equals(key)) {
                continue;
            }
            columns.add(key);
        }
        String join = StringUtils.join(columns, ",");
        sb.append(join);
        // 转成 VALUES("内容"); 形式
        sb.append(") VALUES ( ");

        for (String key : lineJson.keySet()) {
            String value = lineJson.getString(key);
            key = StringUtils.capitalize(key);
            if (identityField.equals(key)) {
                continue;
            }
            if(StringUtils.startsWith(key, "N_")){
                sb.append(value);
            }else{
                sb.append("'").append(value).append("'");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");

        return sb.toString();
    }
}
