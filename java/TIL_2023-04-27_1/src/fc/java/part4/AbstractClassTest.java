package fc.java.part4;

import fc.java.poly.Animal;
import fc.java.poly.Dog;

public class AbstractClassTest {
    public static void main(String[] args) {
        // 추상클래스는 단독으로 객체를 생성할 수 업쇼다.

        Animal ani = new Dog();
        ani.eat();
//        ani.move();


    }
}
