package org.example;

abstract class Unit{
    abstract void doMove();
}

class Marine extends Unit{

    @Override
    void doMove() {
        System.out.println("마린은 두발로 이동합니다.");

    }
}
public class MyStarcraft {
    public static void main(String[] args) {
        Marine unit1 = new Marine();
        unit1.doMove();

    }
}
