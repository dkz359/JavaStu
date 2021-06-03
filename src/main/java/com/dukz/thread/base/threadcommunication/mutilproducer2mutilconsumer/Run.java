package com.dukz.thread.base.threadcommunication.mutilproducer2mutilconsumer;

/**
 * @author dukezheng
 * @ClassName Run
 * @Description 测试多生产者多消费者
 * @date 2021/6/3 16:12
 * @Version 1.0
 */
public class Run {
	public static void main(String[] args) {
		Object lock = new Object();
		Job job = new Job(lock);
		for (int i = 0; i < 5; i++) {
			TProducer producer = new TProducer(job);
			producer.setName("P"+i);
			producer.start();
		}
		for (int i = 0; i < 5; i++) {
			TConsumer consumer = new TConsumer(job);
			consumer.setName("C"+i);
			consumer.start();
		}
	}
}
