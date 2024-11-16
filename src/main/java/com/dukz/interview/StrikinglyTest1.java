package com.dukz.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName StrikinglyTest1
 * 参数替换：
 *      将{{xxx}}中间的xxx参数用传入的值替换，忽略xxx前后空白符，参数没传抛异常
 * @Author dukz
 * @Date 2022/9/27
 * @Version 1.0
 */
public class StrikinglyTest1 {
    public static void main(String[] args) {
        StrikinglyTest1 test = new StrikinglyTest1();
        Map<String, Object> param = new HashMap<>(4);
        param.put("name", "Bill");
        param.put("age", 21);
        param.put("male", true);
        String str1 = "My name is {{ name }} and I am forever {{ age }}.";
        System.out.println(test.replaceParam(str1, param));
        String str2 = "Say hello to {{ name }}. He is {{ age }}.";
        System.out.println(test.replaceParam(str2, param));
        String str3 = "Tommy is a good friend of {{ name }}. He lives in {{ city }}.";
        System.out.println(test.replaceParam(str3, param));
    }

    public String replaceParam(String text, Map<String, Object> param){
        char[] textCS = text.toCharArray();
        int textLen = textCS.length;
        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = -1;
        for (int i = 0; i < textLen-4; i++) {
            if(textCS[i] != '{' || textCS[++i] != '{'){
                continue;
            }
            end = i-1;
            StringBuilder paramKey = new StringBuilder();
            while (i < textLen-2){
                i++;
                if(textCS[i] == ' ' || textCS[i] == '\t' || textCS[i] == '\n'){
                    continue;
                }
                if(textCS[i] != '}' || textCS[i+1] != '}'){
                    paramKey.append(textCS[i]);
                }else{
                    i++;
                    String key = paramKey.toString();
                    Object obj = param.get(key);
                    if(obj == null){
                        throw new RuntimeException("The variable \"" + key + "\" is missing from the keys of the values object!");
                    }
                    res.append(text, start, end)
                            .append(Objects.toString(obj));
                    start = i+1;
                    break;
                }
            }
        }
        if(end == -1){
            return text;
        }
        if(start < textLen){
            res.append(text, start, textLen);
        }
        return res.toString();
    }

}
