package fc.java.part4;

import fc.java.poly.Animal;
import fc.java.poly.Cat;
import fc.java.poly.Dog;

public class IsNotOverride {
    public static void main(String[] args) {
        Animal ani =new Dog();
        ani.eat();

        ani=new Cat();
        ani.eat();


    }
}
