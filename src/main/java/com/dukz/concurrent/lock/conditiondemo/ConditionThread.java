package com.dukz.concurrent.lock.conditiondemo;

/**
 * @ClassName ConditionThread
 * @Description 测试Condition线程
 * @Author dukz
 * @Date 6/9/21
 * @Version 1.0
 */
public class ConditionThread extends Thread {
    private MyService myService;

    public ConditionThread(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitMethod();
    }
}
