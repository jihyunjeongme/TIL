package fc.java.part3;

import fc.java.model.PersonVO;

public class ConstructorOverloading {
    public static void main(String[] args) {
        PersonVO p=new PersonVO("홍길도",50,"011-1111-1111");
        System.out.println(p.getAge()+p.getName()+p.getPhone());
    }
}
