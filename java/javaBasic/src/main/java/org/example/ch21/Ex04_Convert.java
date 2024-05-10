package org.example.ch21;

import java.util.*;

public class Ex04_Convert {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "전우치");
//        list.add("멀린");

        list = new ArrayList<>(list);
        list.add("해리포터");

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.print(itr.next() + '\t');
        }
        System.out.println();

        list = new LinkedList<>(list);

        for (String s : list)
            System.out.print(s + '\t');


        System.out.println();
    }
}


