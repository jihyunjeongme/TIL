package fc.java.part4;

import fc.java.model.Animal;
import fc.java.model.Cat;
import fc.java.model.Dog;

public class DogCatUpcastingTest {
    public static void main(String[] args) {
        // Dog객체를 사용해보자

        Animal x = new Dog();
        x.eat();

        x=new Cat();
        x.eat();

    }
}
