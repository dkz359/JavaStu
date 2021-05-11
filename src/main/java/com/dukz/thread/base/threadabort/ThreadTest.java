package com.dukz.thread.base.threadabort;

import com.dukz.utils.ThreadUtils;

/**
 * @author dukezheng
 * @ClassName ThreadTest
 * @Description TODO
 * @date 2021/5/11 20:24
 * @Version 1.0
 */
public class ThreadTest {
	public static void main(String[] args) {
		StopThread thread = new StopThread();
		thread.start();
		// 休眠1秒，保证i自增完成
		ThreadUtils.sleepSecond(1);
		// 错误中止线程
		// thread.stop();
		// 正确中止线程
		thread.interrupt();

		while(thread.isAlive()){
			// 确保线程已经中止
		}
		thread.print();
	}
}