package com.dukz.tools;

/**
 * @ClassName SleepUtils
 * @Description 线程睡眠工具类
 * @Author dukz
 * @Date 4/8/21
 * @Version 1.0
 */
public class SleepUtils {

    /**
     * 睡眠second秒
     * @param second
     */
    public static void second(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 睡眠millis毫秒
     * @param millis
     */
    public static void millis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
