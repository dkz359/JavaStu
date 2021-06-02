package com.dukz.thread.base.threadcommunication.producer2consumer;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Consumer
 * @Description 消费者
 * @Author dukz
 * @Date 6/2/21
 * @Version 1.0
 */
public class Consumer {
    private Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock) {
                if (StringUtils.equals("", ValueObject.value)) {
                    lock.wait();
                }
                System.out.println("get的值是："+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
