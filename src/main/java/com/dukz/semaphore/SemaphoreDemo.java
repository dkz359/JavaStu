package com.dukz.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author dukezheng
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @date 2021/3/23 21:06
 * @Version 1.0
 */
// 信号量机制
public class SemaphoreDemo {
	public static void main(String[] args) {
		SemaphoreDemo semaphoreTest = new SemaphoreDemo();
		// 客人数量
		int N = 10;
		// 手牌数量，限制请求数量
		Semaphore semaphore = new Semaphore(5);
		semaphore.release(2);
		for (int i = 0; i < N; i++) {
			String vipNo = "vip-00" + i;
			new Thread(() -> {
				try {
					// 获取令牌
					// semaphore.acquire();
					if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
						semaphoreTest.service(vipNo);
						// 释放令牌
						semaphore.release();
					} else {
						System.out.println("vipNo超时");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}

	/**
	 * 限流 控制5个线程 同时访问
	 */
	public void service(String vipNo) throws InterruptedException {
		System.out.println("楼上出来迎接贵宾一位，贵宾编号" + vipNo + "，...");
		Thread.sleep(new Random().nextInt(3000));
		System.out.println("欢送贵宾出门，贵宾编号" + vipNo);
	}
}
