package org.example.ch21;

import java.util.*;

public class Ex17_CollectionsSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "멀린");
        list = new ArrayList<>(list);

        System.out.println("list = " + list);

        Collections.sort(list);

        System.out.println("list = " + list);
    }
}
