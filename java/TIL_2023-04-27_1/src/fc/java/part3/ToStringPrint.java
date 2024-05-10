package fc.java.part3;

import fc.java.model.PersonVO;

public class ToStringPrint {
    public static void main(String[] args) {
        PersonVO p=new PersonVO();
        PersonVO p2=new PersonVO("홍길동",50,"011-1111-1111");

        System.out.println(p2);
    }
}
