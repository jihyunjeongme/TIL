package fc.java.course2.part2;

import fc.java.model2.Converter;
import fc.java.model2.IntegerUtils;

public class IntegerUtilsTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter = IntegerUtils::stringToInt;
        int result=converter.conver("123");
        System.out.println("result " + result );

    }
}
