package com.dukz;

import com.google.common.collect.ArrayListMultimap;
import org.apache.commons.lang3.Conversion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/**
 * @author dukezheng
 * @ClassName Test
 * @Description TODO
 * @date 2020/11/3 21:40
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
    	String s1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(s1.intern() == s1);

		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2.intern() == s2);
    }

}


