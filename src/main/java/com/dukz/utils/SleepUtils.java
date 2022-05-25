package com.dukz.utils;

import java.util.concurrent.TimeUnit;

/**
 * SleepUtils
 *
 * @author dukezheng
 * @ClassName SleepUtils
 * @date 2022/5/25 11:56
 */
public class SleepUtils {
    public static void second(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void millis(long millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
