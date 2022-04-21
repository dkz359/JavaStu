package com.dukz.thread.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 *
 * @author dukezheng
 * @ClassName InturnPrint_Synchronized
 * @date 2022/4/21 17:50
 */
public class InturnPrint_ReentrantLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition();
        Condition conditionT2 = lock.newCondition();
        String s1 = "1234567";
        String s2 = "ABCDEFG";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    conditionT2.signal();
                    conditionT1.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars2) {
                    System.out.print(c);
                    conditionT1.signal();
                    conditionT2.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
