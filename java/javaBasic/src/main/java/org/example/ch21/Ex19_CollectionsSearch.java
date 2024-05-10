package org.example.ch21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex19_CollectionsSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("전우치");
        list.add("손오공");

        Collections.sort(list);

        int idx1 = Collections.binarySearch(list, "손오공");
        System.out.println("idx1 = " + idx1);

        int idx2 = Collections.binarySearch(list, "멀린");
        System.out.println("idx2 = " + idx2);


    }
}
