package fc.java.course2.part2;

import fc.java.model2.Converter;
import fc.java.model2.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
        Converter<String, String> converter = stringUtils::reverse;
        String result = converter.conver("hello");
        System.out.println(result);

    }
}
