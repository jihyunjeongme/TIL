package org.example.ch21;

import java.util.HashMap;
import java.util.Set;

public class Ex15_HashMapKeySet {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("홍길동", 20);
        map.put("전우치", 25);
        map.put("손오공", 26);

        Set<String> ks = map.keySet();

        for (String s : ks) {
            System.out.print("s = " + s);
        }
        System.out.println();

        for (String s : ks) {
            System.out.print(map.get(s).toString() + '\t');
        }
        System.out.println();
    }
}
