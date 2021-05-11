package com.dukz.thread.base.threadabort;

import com.dukz.utils.ThreadUtils;

/**
 * @author dukezheng
 * @ClassName StopThread
 * @Description TODO
 * @date 2021/5/11 20:15
 * @Version 1.0
 */
public class StopThread extends Thread {

	private int i = 0, j = 0;

	@Override public void run() {
		synchronized (this) {
			++i;
			ThreadUtils.sleepSecond(10);
			++j;
		}
	}

	public void print() {
		System.out.println("i=" + i + " j=" + j);
	}
}
