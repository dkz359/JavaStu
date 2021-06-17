package com.dukz.lock.conditiondemo.producer2consumer;

/**
 * @ClassName Run
 * @Description 测试worker
 * @Author dukz
 * @Date 6/15/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        Worker worker = new Worker();
        ThreadA[] tA = new ThreadA[10];
        ThreadB[] tB = new ThreadB[10];

        for (int i = 0; i < 10; i++) {
            tA[i] = new ThreadA(worker);
            tB[i] = new ThreadB(worker);

            tA[i].start();
            tB[i].start();
        }
    }
}
