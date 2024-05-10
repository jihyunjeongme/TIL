package fc.java.course2.part1;

import fc.java.model2.BookArray;
import fc.java.model2.Book;

public class MyBookArraryTest {
    public static void main(String[] args) {
        // 책 3권의 데이터를 [배열]에 저장하고 출력하세요? Book[]
        BookArray list=new BookArray(); // 책, 길이 5
        list.add(new Book("자바",15000,"한빛","정지현"));
        list.add(new Book("C",17000,"한빛","정시현"));
        list.add(new Book("파이썬",25000,"한빛","정구현"));

        System.out.println(list.get(-1));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }

    }
}
