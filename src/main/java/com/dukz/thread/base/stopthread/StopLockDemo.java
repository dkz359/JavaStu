package com.dukz.thread.base.stopthread;

/**
 * @ClassName StopLockDemo
 * @Description stop方法释放锁会导致数据不一致
 * @Author dukz
 * @Date 5/14/21
 * @Version 1.0
 */
public class StopLockDemo {
    public static void main(String[] args) {
        try {
            SynchronizedObject obj = new SynchronizedObject();
            MyThread1 thread1 = new MyThread1(obj);
            thread1.start();
            Thread.sleep(500);
            thread1.stop();
            //thread1.interrupt();
            // interrupt方法需要时间执行setPassword
            Thread.sleep(1000);
            System.out.println(obj.getUsername()+" --- "+obj.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread1 extends Thread{
    private SynchronizedObject obj;

    public MyThread1(SynchronizedObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        super.run();
        obj.printStr("b", "bb");
    }
}

class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printStr(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }
}
