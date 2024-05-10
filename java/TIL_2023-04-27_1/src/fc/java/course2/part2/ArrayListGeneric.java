package fc.java.course2.part2;

import fc.java.model2.Movie;

import java.util.ArrayList;
import java.util.List;

public class ArrayListGeneric {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList();
        list.add(new Movie("괴물","봉준호","2006","한국"));
//        list.add("Hello");

        System.out.println(list.get(0));
//        System.out.println(list.get(1));

    }
}
