package thread.t1;

/**
 * @ClassName MyThread
 * @Description
 * @Author dukz
 * @Date 2/15/21
 * @Version 1.0
 */
public class MyThread extends Thread{
    private int count = 5;
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    @Override
    synchronized public void run() {
        count--;
        System.out.println("由 "+Thread.currentThread().getName()+" 计算，count="+count);
    }
}
