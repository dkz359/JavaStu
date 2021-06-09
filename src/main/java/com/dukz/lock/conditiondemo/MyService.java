package com.dukz.lock.conditiondemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyService
 * @Description Condition使用类
 * @Author dukz
 * @Date 6/9/21
 * @Version 1.0
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod(){
        try {
            lock.lock();
            System.out.println("await time: "+ System.currentTimeMillis());
            condition.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalMethod(){
        try {
            lock.lock();
            System.out.println("signal time: "+ System.currentTimeMillis());
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
