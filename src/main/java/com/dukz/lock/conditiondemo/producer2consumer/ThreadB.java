package com.dukz.lock.conditiondemo.producer2consumer;

/**
 * @ClassName ThreadB
 * @Description 启动消费者
 * @Author dukz
 * @Date 6/15/21
 * @Version 1.0
 */
public class ThreadB extends Thread {
    private Worker worker;

    public ThreadB(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            worker.get();
        }
    }
}
