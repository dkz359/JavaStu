package thread.t1;

/**
 * @ClassName MyRunnable
 * @Description 实现runnable接口
 * @Author dukz
 * @Date 2/15/21
 * @Version 1.0
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中！");
    }
}
