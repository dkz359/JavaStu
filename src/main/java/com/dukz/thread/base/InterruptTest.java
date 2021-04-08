package com.dukz.thread.base;

import com.dukz.tools.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InterruptTest
 * @Description 测试线程中断
 * @Author dukz
 * @Date 4/8/21
 * @Version 1.0
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());

        SleepUtils.second(2);
    }


    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){}
        }
    }
}
