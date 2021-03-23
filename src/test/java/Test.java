import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dukezheng
 * @ClassName Test
 * @Description TODO
 * @date 2020/11/3 21:40
 * @Version 1.0
 */
public class Test {

    public static final Pattern pattern = Pattern.compile("(\\d)+");
    public static void main(String[] args) {
        String ah = "（2021）湘民初1000号";
        Matcher matcher = pattern.matcher(ah);
        matcher.find();
        System.out.println(matcher.group());
        matcher.find();
        System.out.println(matcher.group());
    }
}
