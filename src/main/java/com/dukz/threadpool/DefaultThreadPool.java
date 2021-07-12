package com.dukz.threadpool;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName DefaultThreadPool
 * @Description 自定义默认线程池实现
 * @Author dukz
 * @Date 7/12/21
 * @Version 1.0
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    /**
     * 最大线程数
     */
    public static final int MAX_WORKER_NUMBERS = 10;
    /**
     * 默认线程数
     */
    public static final int DEFAULT_WORKER_NUMBERS = 5;
    /**
     * 最小线程数
     */
    public static final int MIN_WORKER_NUMBERS = 1;

    /**
     * 工作列表，将存放需要执行的工作
     */
    private final LinkedList<Job> jobs = new LinkedList<>();
    /**
     * 工作者列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    // 工作者数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    // 线程编号
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }

    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if(num+this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum+= num;
        }

    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs){
            if (num >= this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count < num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum-=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "threadPool-worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    /**
     * 工作者，负责消费任务
     */
    class Worker implements Runnable{
        // 是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出一个job
                    job = jobs.removeFirst();
                }
                if (job!=null){
                    job.run();
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }
}
