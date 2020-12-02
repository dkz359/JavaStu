import java.util.HashMap;
import java.util.Map;

/**
 * @author dukezheng
 * @ClassName Test
 * @Description TODO
 * @date 2020/11/3 21:40
 * @Version 1.0
 */
public class Test {
    public static Map<String, String> map = new HashMap<String, String>(){
        {
            put("a","A");
            put("b","B");
            put("c","C");
            put("d","D");
        }
    };
    public static void main(String[] args) {
        System.out.println(map.get("a"));
    }
}
