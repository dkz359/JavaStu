package com.dukz.thread.base.threadcommunication.producer2consumer;


/**
 * @ClassName Run
 * @Description 运行测试
 * @Author dukz
 * @Date 6/2/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        ProducerThread p = new ProducerThread(producer);
        ConsumerThread c = new ConsumerThread(consumer);
        p.setName("P");
        c.setName("C");
        p.start();
        c.start();
    }
}
