package thread.t1.threadsafe;

/**
 * @ClassName BLogin
 * @Description
 * @Author dukz
 * @Date 2/16/21
 * @Version 1.0
 */
public class BLogin extends Thread {
    @Override
    public void run() {

        LoginServlet.doPost("b", "bb");
    }
}
