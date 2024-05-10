package fc.java.course2.part2;

import java.util.ArrayList;

public class CollectionBasic {
    public static void main(String[] args) {
        // ArrayList에 10,20,30,40,50 5개의 정수(int)를 저장하고 출력하세요.
        // ArrayList -> Object[] <---- int형 자료는 넣을 수 없음.
        // ArrayList -> Object[] <---- Integer(Wrapper)
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(29);
        list.add(39);
        list.add(49);
        list.add(59);
        list.add(69);

        for(int data : list){
            System.out.println(data);
        }

//        System.out.println(list);

    }
}
