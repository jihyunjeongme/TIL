package org.example;

abstract class Animal
{
    abstract void doMove();
}

class Tiger extends Animal
{
    @Override
    void doMove() {
        System.out.println("호랑이는 산을 달립니다.");
    }
}

class Lion extends Animal
{
    @Override
    void doMove() {
        System.out.println("사자는 평원을 달립니다.");
    }
}

public class Ex04_Polymorphism3 {
    public static void annimalChoose(Animal obj)
    {
        if (obj instanceof Tiger){
            Tiger tiger = (Tiger) obj;
            tiger.doMove();
        } else {
            Lion lion = (Lion) obj;
            lion.doMove();
        }
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        annimalChoose(tiger);

        Lion lion = new Lion();
        annimalChoose(lion);

    }
}
