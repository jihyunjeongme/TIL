package org.example.ch22;

class HumanCamp2
{
    private int speed = 10;

    public void getMarine()
    {
        class Marine2
        {
            public void move()
            {
                System.out.println("인강형 유닛이" + speed + "속도로 이동합니다.");
            }
        }

        Marine2 inner = new Marine2();
        inner.move();
    }
}
public class Ex02_LocalInner {
    public static void main(String[] args) {
        HumanCamp2 humanCamp2 = new HumanCamp2();
        humanCamp2.getMarine();
    }
}
