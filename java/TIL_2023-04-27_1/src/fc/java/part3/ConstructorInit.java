package fc.java.part3;

import fc.java.model.PersonVO;

public class ConstructorInit {
    public static void main(String[] args) {
        PersonVO p=new PersonVO();
        String name=p.getName();
        int age=p.getAge();
        String phone=p.getPhone();

        System.out.println(name+" "+age+" "+phone);
    }
}
