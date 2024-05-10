package fc.java.course2.part1;

import fc.java.model2.Book;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        // Book 3권을
        List<Book> list=new ArrayList<Book>(1); // 기본 크기 10
        list.add(new Book("자바",15000,"한빛","정지현"));
        list.add(new Book("C",17000,"한빛","정시현"));
        list.add(new Book("파이썬",25000,"한빛","정구현"));

//        Book vo=(Book)list.get(0);
//        System.out.println(vo);
//
//        vo=(Book)list.get(1);
//        System.out.println(vo);
//
//        vo=(Book)list.get(2);
//        System.out.println(vo);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}

