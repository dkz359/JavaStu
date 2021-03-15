package thread.t1.threadsafe;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName LoginServlet
 * @Description 模拟登陆servlet
 * @Author dukz
 * @Date 2/16/21
 * @Version 1.0
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;
    synchronized public static void doPost(String username, String password){
        try {
            usernameRef = username;
            if (StringUtils.equals("a", username)){
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username="+usernameRef+" password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
