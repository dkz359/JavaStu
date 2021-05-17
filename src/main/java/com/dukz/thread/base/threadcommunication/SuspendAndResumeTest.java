package com.dukz.thread.base.threadcommunication;

import com.dukz.tools.SleepUtils;

/**
 * @ClassName SuspendAndResumeTest
 * @Description 测试suspend和resume
 * @Author dukz
 * @Date 5/17/21
 * @Version 1.0
 */
public class SuspendAndResumeTest {
    public static void main(String[] args) {
        //testExclusiveLock();
        //testSuspendPrintln();
        testSuspendSyn();
    }


    /**
     * 测试println被suspend暂停
     */
    public static void testSuspendPrintln(){
        Thread t1 = new Thread(()->{
            while (true){
                System.out.println("running");
            }
        });
        t1.start();
        SleepUtils.second(1);
        t1.suspend();
        // t1中的println没有释放锁，不会输出下面这句
        System.out.println("main end");
    }

    /**
     * 测试suspend独占锁问题
     */
    public static void testExclusiveLock(){
        SynObject synObject = new SynObject();
        Thread t1 = new Thread(()->{
            synObject.printStr();
        });
        t1.setName("a");
        t1.start();
        SleepUtils.second(1);
        Thread t2 = new Thread(()->{
            System.out.println("t2进入不了printStr方法，因为suspend没有释放锁");
            synObject.printStr();
        });
        t2.start();
    }

    /**
     * 测试suspend导致数据不同步
     */
    public static void testSuspendSyn(){
        final User user = new User();
        new Thread(()->{
            user.setValue("a", "aa");
        }, "a").start();
        SleepUtils.millis(500);
        new Thread(()->{
            user.printUser();
        }).start();
    }
}


class User{
    private String username = "1";
    private String password = "11";
    public void setValue(String u, String p){
        this.username = u;
        if("a".equals(Thread.currentThread().getName())){
            Thread.currentThread().suspend();
        }
        this.password = p;
    }
    public void printUser(){
        System.out.println(username+"  "+password);
    }
}

class SynObject{
    synchronized public void printStr(){
        System.out.println("begin");
        if("a".equals(Thread.currentThread().getName())){
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
