package fc.java.course2.part2;

import fc.java.model2.Movie;
import fc.java.model2.ObjectArr;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        /*ObjectArr<String> array = new ObjectArr<>(5);

        array.set(0,"Hello");
        array.set(1,"World");
        array.set(2,"Java");
        array.set(3,"Generic");

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }*/

//        ArrayList<Movie> list = new ArrayList<>();
//        list.add(new Movie("괴물","봉중호","2006","한국"));
//        list.add(new Movie("기생충","봉중호","2019","한국"));
//        list.add(new Movie("완벽한 타인","이재규","2018","한국"));

        ObjectArr<Movie> bList = new ObjectArr<>(5);
        bList.set(0, new Movie("괴물","봉중호","2006","한국"));
        bList.set(1, new Movie("기생충","봉중호","2019","한국"));
        bList.set(2, new Movie("완벽한 타인","이재규","2018","한국"));

        for (int i = 0; i < bList.size(); i++) {
            System.out.println(bList.get(i));

        }
//        bList.set(3,"name");



    }
}
