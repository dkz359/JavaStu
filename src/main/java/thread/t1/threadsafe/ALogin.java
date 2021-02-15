package thread.t1.threadsafe;

/**
 * @ClassName ALogin
 * @Description
 * @Author dukz
 * @Date 2/16/21
 * @Version 1.0
 */
public class ALogin extends Thread {
    @Override
    public void run() {

        LoginServlet.doPost("a", "aa");
    }
}
