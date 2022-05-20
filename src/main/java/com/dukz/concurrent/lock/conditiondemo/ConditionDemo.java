package com.dukz.concurrent.lock.conditiondemo;

import com.dukz.utils.SleepUtils;

/**
 * @ClassName ConditionDemo
 * @Description Condition测试
 * @Author dukz
 * @Date 6/9/21
 * @Version 1.0
 */
public class ConditionDemo {
    public static void main(String[] args) {
        MyService myService = new MyService();

        ConditionThread thread = new ConditionThread(myService);
        thread.start();

        SleepUtils.second(3);
        myService.signalMethod();
    }
}
