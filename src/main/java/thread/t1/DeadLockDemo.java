package thread.t1;

/**
 * @ClassName DeadLockDemo
 * @Description 死锁测试
 * @Author dukz
 * @Date 3/10/21
 * @Version 1.0
 */
public class DeadLockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("1");
                }
            }
        }, "线程1");
        Thread t2 = new Thread(()->{
            synchronized (lock2){
                synchronized (lock1){
                    System.out.println("2");
                }
            }
        }, "线程2");
        t1.start();
        t2.start();
    }
}
