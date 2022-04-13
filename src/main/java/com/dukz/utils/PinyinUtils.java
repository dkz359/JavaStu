package com.dukz.utils;

import com.github.promeg.pinyinhelper.Pinyin;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 * 中文转拼音
 *
 * @author dukezheng
 * @ClassName PinyinUtils
 * @date 2022/4/13 17:02
 */
public class PinyinUtils {
    /**
     *  获取汉字的拼音首字母
     * @param chinese  汉字字符串
     * @param delim 连接分割符
     * @return
     */
    public static String getFirstLetter(String chinese){
        // 1. 生成拼音
        String pinyin = Pinyin.toPinyin(chinese," ");
        // 2. 生成拼音首字母数组
        Character[] chars = Arrays.stream(pinyin.split(" "))
                .map(val -> val.charAt(0)).toArray(Character[]::new);
        // 3. 数组转字符串
        return StringUtils.join(chars, "");
    }
}
