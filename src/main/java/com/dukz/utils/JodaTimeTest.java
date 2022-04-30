package com.dukz.utils;

import org.joda.time.DateTime;

/**
 * @author dukezheng
 * @ClassName JodaTimeTest
 * @Description TODO
 * @date 2021/1/5 16:39
 * @Version 1.0
 */
public class JodaTimeTest {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        System.out.println(dateTime.toString("yyyyMMddhhmmssSSS"));
        System.out.println(dateTime.year());
    }
}
