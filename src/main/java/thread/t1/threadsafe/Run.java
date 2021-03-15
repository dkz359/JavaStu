package thread.t1.threadsafe;

/**
 * @ClassName Run
 * @Description
 * @Author dukz
 * @Date 2/16/21
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        System.out.println("是否停止1 = "+Thread.currentThread().isInterrupted());
        System.out.println("是否停止2 = "+Thread.currentThread().isInterrupted());
        System.out.println("end");
    }
}
