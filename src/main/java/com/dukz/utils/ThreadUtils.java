package com.dukz.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author dukezheng
 * @ClassName ThreadUtils
 * @Description TODO
 * @date 2021/5/11 20:17
 * @Version 1.0
 */
public class ThreadUtils {

	/**
	 * @Author dukezheng
	 * @Description 睡time毫秒
	 * @Date 20:20 2021/5/11
	 * @Param
	 * @return
	 */
	public static void sleepMillis(long time){
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Author dukezheng
	 * @Description 睡time秒
	 * @Date 20:20 2021/5/11
	 * @Param
	 * @return
	 */
	public static void sleepSecond(long time){
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
