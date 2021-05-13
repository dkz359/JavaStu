package com.dukz.thread.base.IsAliveDemo;

/**
 * @ClassName MyThread
 * @Description 测试isAlive
 * @Author dukz
 * @Date 5/13/21
 * @Version 1.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run= "+this.isAlive());
    }
}
