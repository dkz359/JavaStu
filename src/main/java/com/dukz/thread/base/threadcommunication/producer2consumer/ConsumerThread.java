package com.dukz.thread.base.threadcommunication.producer2consumer;

/**
 * @ClassName ConsumerThread
 * @Description 消费者线程
 * @Author dukz
 * @Date 6/2/21
 * @Version 1.0
 */
public class ConsumerThread extends Thread {
    private Consumer consumer;

    public ConsumerThread(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}
