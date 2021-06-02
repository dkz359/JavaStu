package com.dukz.thread.base.threadcommunication.producer2consumer;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Producer
 * @Description 生产者
 * @Author dukz
 * @Date 6/2/21
 * @Version 1.0
 */
public class Producer {
    private Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                if(!StringUtils.equals("", ValueObject.value)){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是：" + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
