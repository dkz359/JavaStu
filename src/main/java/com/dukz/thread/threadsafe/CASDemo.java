package com.dukz.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-15
 * @Version 1.0
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5);

        System.out.println(ai.compareAndSet(5,2020)+"\tnow ai="+ai.get());
        System.out.println(ai.compareAndSet(5,1024)+"\tnow ai="+ai.get());
    }
}
