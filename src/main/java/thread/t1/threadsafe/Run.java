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
        ALogin a =  new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
