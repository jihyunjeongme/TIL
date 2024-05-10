package org.example;

interface Greet{
    void greet();
}

interface Talk{
    void talk();
}

class Morning implements Greet, Talk{
    @Override
    public void greet() {
        System.out.println("안녕하세요!");
    }

    @Override
    public void talk() {
        System.out.println("날씨가 좋네요");

    }
}

public class Ex01_Meet {
    public static void main(String[] args) {
        Morning morning = new Morning();
        morning.greet();
        morning.talk();

    }
}
