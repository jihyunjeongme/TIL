package fc.java.course2.part1;

import fc.java.model2.*;
import fc.java.model2.ObjectArray;

public class MyObjectArraryTest {
    public static void main(String[] args) {
        // A, B, C 객체를 배열(Object[])에 저장하고 출력하세요.
        ObjectArray list=new ObjectArray();
        list.add(new A());
        list.add(new B());
        list.add(new C());

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof A){

                A a=(A)list.get(i);
                a.display();
            }else if (list.get(i) instanceof  B) {
                B b=(B)list.get(i);
                b.display();

            }else {
                C c=(C)list.get(i);
                c.display();

            }
        }

    }
}
