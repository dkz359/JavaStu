package thread.t1;

/**
 * @ClassName Run
 * @Description 运行线程
 * @Author dukz
 * @Date 2/15/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
