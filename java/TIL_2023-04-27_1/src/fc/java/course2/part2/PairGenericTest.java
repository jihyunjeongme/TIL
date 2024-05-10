package fc.java.course2.part2;

import fc.java.model2.Pair;

import java.util.HashMap;
import java.util.Map;

public class PairGenericTest {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello", 1);
        System.out.println(pair.getKey() + " " +pair.getValue());

        Map<String, Integer> maps = new HashMap<>();

    }
}
