package com.dukz.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName ArrayBlockingQueueDemo
 * @Description TODO
 * @Author dukz
 * @Date 2020-06-28
 * @Version 1.0
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(6);
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);


        new Thread(()->{
            while (true) {
                try {
//                    System.out.println("读取到数据： " + queue.poll()+"   queue的长度："+queue.size());
                    System.out.println("读取到数据： "+queue.take()+"   queue的长度："+queue.size());
                    Thread.sleep(1000L);
                } catch (Exception e) {

                }
            }
        }).start();
        Thread.sleep(3000L);

        for (int i=0;i<6;i++){
            new Thread(()->{
                try {
                    queue.put(Thread.currentThread().getName());
//                    queue.offer(Thread.currentThread().getName());

                    System.out.println(Thread.currentThread()+"装入数据"+"   queue的长度："+queue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
