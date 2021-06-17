package com.dukz.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TimerTaskDemo
 * @Description 测试定时器Timer
 * @Author dukz
 * @Date 6/17/21
 * @Version 1.0
 */
public class TimerTaskDemo {
    public static void main(String[] args) {
        System.out.println("当前时间为："+new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();

        MyTask myTask = new MyTask();
        // new Timer(true)  将timer设置为守护线程
        Timer timer = new Timer();
        timer.schedule(myTask, runDate);
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("任务执行了，当前时间为："+new Date());
    }
}
