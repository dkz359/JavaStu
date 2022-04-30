package com.dukz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.DateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * qqtest
 *
 * @ClassName QQTest
 * @Author dukz
 * @Date 2022/4/6
 * @Version 1.0
 */
public class QQTest {


    public static void main(String[] args) throws  Exception{
        String path = QQTest.class.getClassLoader().getResource("dukzqq.json").getPath();
        List<String> dukzQQList = getQQList(readJsonFile(path));
        System.out.println(StringUtils.join(dukzQQList, ","));
        System.out.println(dukzQQList.contains("1215488031"));
    }


    /**
     * 获取qqList
     * @param jsonStr
     * @return
     */
    public static List<String> getQQList(String jsonStr) {
        JSONObject jobj = (JSONObject) JSON.parseObject(jsonStr);
        JSONArray jsonArray = jobj.getJSONObject("data").getJSONArray("items");
        List<String> qqList = jsonArray.stream().map(json -> {
            return ((JSONObject) json).getString("uin");
        }).collect(Collectors.toList());
        return qqList;
    }

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

}
