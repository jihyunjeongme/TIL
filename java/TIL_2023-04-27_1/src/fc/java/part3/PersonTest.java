package fc.java.part3;

public class PersonTest {
    public static void main(String[] args) {
        // Q. 한 [사람]의 데이터를 저장할 [변수를 선언]하세요.
        Person p = new Person();
        p.name="홍길동";
        p.age=30;
        p.phone="010-1111-1111";

        System.out.println(p.name+p.age+p.phone);

        p.play();
        p.eat();
        p.walk();

        Person p1 = new Person();
        p1.name="나길동";
        p1.age=34;
        p1.phone="010-222-222";

        System.out.println(p1.name+p1.age+p1.phone);

        p1.play();
        p1.eat();
        p1.walk();

    }
}
