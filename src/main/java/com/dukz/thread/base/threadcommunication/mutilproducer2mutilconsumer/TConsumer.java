package com.dukz.thread.base.threadcommunication.mutilproducer2mutilconsumer;

/**
 * @author dukezheng
 * @ClassName TConsumer
 * @Description 消费者线程
 * @date 2021/6/3 16:09
 * @Version 1.0
 */
public class TConsumer extends Thread {
	private Job job;
	public TConsumer(Job job){
		this.job = job;
	}

	@Override public void run() {
		while (true){
			job.pop();
		}
	}
}
