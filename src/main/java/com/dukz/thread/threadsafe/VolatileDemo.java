package com.dukz.thread.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-11
 * @Version 1.0
 * volatile保证可见性、不保证原子性、防止指令重排序
 */
public class VolatileDemo {

    public static void main(String[] args) {
//        visibility();

        atomicity();

//        atomicClass();
    }

    /*利用atomic原子类保证原子性*/
    public static void atomicClass(){
        MyData myData = new MyData();


        for (int i =0; i<20; i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        /*等待其他线程结束，默认活动的线程只有main和gc线程*/
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\tfinally number value: "+myData.ai);
    }
    /*volatile不保证原子性*/
    public static void atomicity(){
        MyData myData = new MyData();

        for (int i =0; i<20; i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    myData.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }
        /*等待其他线程结束，默认活动的线程只有main和gc线程*/
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\tfinally number value: "+myData.num);
    }

    /**
     * @Author dukz
     * @Description //TODO 验证volatile的可见性
     * @Date 2020-06-11
     * @Param []
     * @return void
     **/
    public static void visibility(){
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\tcome in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.change();
            System.out.println(Thread.currentThread().getName()+"\tupdate num value: "+myData.num);
        },"AAA").start();

        while(myData.num == 0){
            // 如果线程可见，那么num变成60后会自动退出
        }

        System.out.println(Thread.currentThread().getName()+"\tmission is over，main get num value: "+myData.num);
    }
}
class MyData{
    // 共享变量不加volatile修饰，线程不可见
    int num = 0;
//    volatile int num = 0;

    void change(){
        num = 60;
    }
    /*虽然用volatile修饰了num，但不保证原子性，需用synchronized或者atomic类，但不建议用synchronized（太重量级了）*/
    synchronized void addPlusPlus(){
        num++;
    }

    AtomicInteger ai = new AtomicInteger();

    void addAtomic(){
        ai.getAndIncrement();
    }
}