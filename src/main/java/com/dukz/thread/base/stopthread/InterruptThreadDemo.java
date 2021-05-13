package com.dukz.thread.base.stopthread;

import com.dukz.tools.SleepUtils;

/**
 * @ClassName InterruptThreadDemo
 * @Description 使用interrupt方法停止线程
 * @Author dukz
 * @Date 5/14/21
 * @Version 1.0
 */
public class InterruptThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        SleepUtils.second(2);
        myThread.interrupt();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 5000000; i++) {
                if(this.isInterrupted()){
                    System.out.println("线程停止，即将退出");
                    throw new InterruptedException();
                    // 使用return也可以停止线程，但还是建议使用抛异常，这样可以在catch中控制程序的运行流程
                    //return;
                }
                System.out.println("i=" + (++i));
            }
        } catch (InterruptedException e) {
            System.out.println("MyThread的run方法中的catch");
            e.printStackTrace();
        }
    }
}
