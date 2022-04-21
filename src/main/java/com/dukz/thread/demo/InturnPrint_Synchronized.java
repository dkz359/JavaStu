package com.dukz.thread.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 交替打印
 *
 * @author dukezheng
 * @ClassName InturnPrint_Synchronized
 * @date 2022/4/21 17:50
 */
public class InturnPrint_Synchronized {
    public static final Object lock = new Object();
    public static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        String s1 = "1234567";
        String s2 = "ABCDEFG";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Thread t1 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                for (char c : chars1) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 没有通知，程序不能正确退出，会有一个wait
                lock.notify();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (char c : chars2) {
                    System.out.print(c);
                    latch.countDown();
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 没有通知，程序不能正确退出，会有一个wait
                lock.notify();
            }
        });
        t1.start();
        t2.start();
    }
}
