package org.example.ch22;

class Outer1 {
    private int speed = 10;

    class MemberInner1 {
        public void move() {
            System.out.println("인간형 유닛이 속도로 이동합니다." + speed);

        }
    }

    public void getMarine() {
        MemberInner1 inner1 = new MemberInner1();
        inner1.move();
    }
}


public class Ex01_MemberInner {
    public static void main(String[] args) {
        Outer1 out = new Outer1();

        out.getMarine();
        Outer1.MemberInner1 inner1 = out.new MemberInner1();

        inner1.move();


    }

}
