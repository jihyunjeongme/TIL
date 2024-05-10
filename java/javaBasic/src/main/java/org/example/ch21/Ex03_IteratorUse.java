package org.example.ch21;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex03_IteratorUse {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // 순서 있음. 중복 허용
        list.add("orange");
        list.add("apple");
        list.add("apple");
        list.add("banana");

        for (String s : list) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // 반복자 획득
        Iterator<String> itr = list.iterator();

        // 반복자를 이용한 순차적 참조
        String str;
        while (itr.hasNext())
        {
            str = itr.next();
            System.out.print(str + "\t");

            if(str.equals("orange"))
                itr.remove();
        }

        System.out.println();


        // 반복자 획득
        itr = list.iterator();

        while (itr.hasNext())
            System.out.println(itr.next() + "\t");

        System.out.println();
    }
}
