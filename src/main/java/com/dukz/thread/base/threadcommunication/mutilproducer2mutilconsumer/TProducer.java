package com.dukz.thread.base.threadcommunication.mutilproducer2mutilconsumer;

/**
 * @author dukezheng
 * @ClassName TProducer
 * @Description 生产者线程
 * @date 2021/6/3 16:09
 * @Version 1.0
 */
public class TProducer extends Thread {
	private Job job;
	 public TProducer(Job job){
	 	this.job = job;
	 }

	@Override public void run() {
		while (true){
			job.push();
		}
	}
}
