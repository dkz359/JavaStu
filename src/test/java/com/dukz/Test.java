package com.dukz;

import com.dukz.utils.PinyinUtils;
import com.github.promeg.pinyinhelper.Pinyin;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dukezheng
 * @ClassName Test
 * @Description TODO
 * @date 2020/11/3 21:40
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
		String chinese = "其他（婚姻登记、不履行法定职责、消费者权益保护、人防设施）";
		System.out.println(Pinyin.toPinyin(chinese," "));
		System.out.println(PinyinUtils.getFirstLetter(chinese));
		System.out.println(StringUtils.lowerCase(PinyinUtils.getFirstLetter(chinese)));
    }

}


