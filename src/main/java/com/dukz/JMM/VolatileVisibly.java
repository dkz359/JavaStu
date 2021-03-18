package com.dukz.JMM;


/**
 * @author dukezheng
 * @ClassName VolatileVisibly
 * @Description TODO
 * @date 2021/3/16 23:31
 * @Version 1.0
 */
public class VolatileVisibly {
    public static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(()->{
            run();
        }).start();
        System.out.println("main is in");
        while (!flag){
        }
        System.out.println("over");
    }

    private static void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag now is true");
    }

}
