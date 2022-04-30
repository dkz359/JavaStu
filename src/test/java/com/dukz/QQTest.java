package com.dukz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dukz.utils.JSONUtils;
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
        List<String> dukzQQList = getQQList(JSONUtils.readJsonFile(path));
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


}
