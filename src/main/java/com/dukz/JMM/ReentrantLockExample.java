package com.dukz.JMM;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockExample
 * @Description 重入锁测试
 * @Author dukz
 * @Date 3/15/21
 * @Version 1.0
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock(true);

    public void writer(){
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try {
            int i = a;
        } finally {
            lock.unlock();
        }
    }
}
