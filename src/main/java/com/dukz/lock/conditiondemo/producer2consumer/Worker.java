package com.dukz.lock.conditiondemo.producer2consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Worker
 * @Description 工作类
 * @Author dukz
 * @Date 6/15/21
 * @Version 1.0
 */
public class Worker {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        lock.lock();
        try {
            while (hasValue == true){
                System.out.println("有可能★★★★连续");
                condition.await();
            }
            System.out.println("打印★★");
            hasValue = true;
            // signal可能出现假死
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try {
            while (hasValue == false){
                System.out.println("有可能☆☆☆☆连续");
                condition.await();
            }
            System.out.println("打印☆☆");
            hasValue = false;
            // signal可能出现假死
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
