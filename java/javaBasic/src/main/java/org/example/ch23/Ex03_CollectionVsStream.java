package org.example.ch23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03_CollectionVsStream {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        List<Integer> list = new ArrayList<>();

        // 컬렉션 프레임워크를 이용한 방식
        for (int i : arr) {
            if (i%2 == 1)
            {
//                System.out.println(i);
                list.add(i);
            }
        }
//        System.out.println(list);

        Collections.sort(list);

        for (int i : list) {
            System.out.print(i + "\t");
        }

        System.out.println();

        // Stream을 이용한 방식
        Arrays.stream(arr)
                .filter(n -> n%2 == 1)
                .sorted()
                .forEach(n -> System.out.print(n + "\t"));

        System.out.println();
    }
}
