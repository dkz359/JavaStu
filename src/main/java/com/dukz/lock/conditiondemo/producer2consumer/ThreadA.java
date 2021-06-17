package com.dukz.lock.conditiondemo.producer2consumer;

/**
 * @ClassName ThreadA
 * @Description 启动生产者
 * @Author dukz
 * @Date 6/15/21
 * @Version 1.0
 */
public class ThreadA extends Thread {
    private Worker worker;

    public ThreadA(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            worker.set();
        }
    }
}
