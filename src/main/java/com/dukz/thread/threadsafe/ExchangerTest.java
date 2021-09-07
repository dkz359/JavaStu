package com.dukz.thread.threadsafe;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ExchangerTest
 * @Description exchanger测试
 * @Author dukz
 * @Date 8/19/21
 * @Version 1.0
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(()->{
            try {
                String A = "银行流水A";
                exgr.exchange(A);
            } catch (InterruptedException e) {
            }
        });
        threadPool.execute(()->{
            try {
                String B = "银行流水B";
                String exchangeA = exgr.exchange(B);
                System.out.println("B录入的是："+B+"\nA录入的是："+exchangeA);
            } catch (InterruptedException e) {
            }
        });

        threadPool.shutdown();
    }
}
