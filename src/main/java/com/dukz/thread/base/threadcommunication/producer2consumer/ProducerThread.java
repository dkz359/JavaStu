package com.dukz.thread.base.threadcommunication.producer2consumer;

/**
 * @ClassName ProducerThread
 * @Description 生产者线程
 * @Author dukz
 * @Date 6/2/21
 * @Version 1.0
 */
public class ProducerThread extends Thread{
    private Producer producer;

    public ProducerThread(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            producer.setValue();
        }
    }
}
