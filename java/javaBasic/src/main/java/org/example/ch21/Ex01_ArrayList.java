package org.example.ch21;

import java.util.ArrayList;
import java.util.List;

public class Ex01_ArrayList {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        // 순서 있음. 중복 허용
        list.add("orange");
        list.add("apple");
        list.add("apple");
        list.add("banana");

        // 객체 참조
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + "\t");
        System.out.println();

        list.remove(0);

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+ "\t");
        System.out.println();


    }
}
