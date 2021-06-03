package com.dukz.thread.base.threadcommunication.mutilproducer2mutilconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dukezheng
 * @ClassName Job
 * @Description 生产消费任务
 * @date 2021/6/3 15:58
 * @Version 1.0
 */
public class Job {
	private volatile List list = new LinkedList();
	private Object lock;

	public Job(Object lock) {
		this.lock = lock;
	}

	public void push(){
		synchronized (lock){
			try {
				// 需要while，如果是if，等待被唤醒后直接往下走了
				while (list.size() == 1){
					System.out.println(Thread.currentThread().getName()+" WAITING");
					lock.wait();
				}
				int e = (int)(Math.random() * 10000);
				list.add(e);
				System.out.println(Thread.currentThread().getName()+" push："+e+" size:"+list.size());
				// 使用notify通知如果唤醒了一个生产者，此时消费者也全在等待，就会假死
				lock.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int pop(){
		synchronized (lock){
			try {
				// 需要while，如果是if，等待被唤醒后直接往下走了
				while (list.size() == 0){
					System.out.println(Thread.currentThread().getName()+" WAITING");
					lock.wait();
				}
				int remove = (int)list.remove(0);
				System.out.println(Thread.currentThread().getName()+" pop："+remove);
				lock.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
