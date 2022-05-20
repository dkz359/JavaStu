package com.dukz.thread.base.IsAliveDemo;

import com.dukz.utils.SleepUtils;

/**
 * @ClassName Demo
 * @Description 测试
 * @Author dukz
 * @Date 5/14/21
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        System.out.println("begin == "+mt.isAlive());
        mt.start();
        // 睡一秒后 mt线程就执行完了
        SleepUtils.second(1);
        System.out.println("end == "+mt.isAlive());
    }
}
