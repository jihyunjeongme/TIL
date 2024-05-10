package fc.java.course2.part2;

import fc.java.model2.A;
import fc.java.model2.Movie;

import java.util.ArrayList;

public class MoveListExample {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("괴물","봉중호","2006","한국"));
        list.add(new Movie("기생충","봉중호","2019","한국"));
        list.add(new Movie("완벽한 타인","이재규","2018","한국"));

//        for (Movie m: list){
//            System.out.println(m);
//        }

        System.out.println("+----------+------+----+------+");
        System.out.println("|영화제목      |감독   |개봉년도|국가|");
        System.out.println("+----------+------+----+------+");
        for(Movie m: list){
            System.out.printf("|%-16s|%-8s|%4s|%-6s\n",m.getTitle(),m.getDirector(),m.getYear(),m.getCountry());
//            System.out.println();
        }
        System.out.println("+----------+------+----+------+");

        String searchTitle = "기생충";
        // 순차검색 -> 이진검색(*)
        for(Movie m : list){
            if(m.getTitle().equals(searchTitle)){
                System.out.println(m);
                break;
            }
        }
    }
}
