package org.example.ch22;

interface Uni3
{
    void move();
}

class HumanCamp3
{
    private int speed = 10;

    public Uni3 getMarine()
    {
        class Marine3 implements Uni3
        {
            public void move()
            {
                System.out.println("인강형 유닛이 속도로 이동합니다." + speed);
            }
        }

        return new Marine3();
    }


}
public class Ex03_AnoymousInner1 {
    public static void main(String[] args) {
        HumanCamp3 hc = new HumanCamp3();
        Uni3 unit = hc.getMarine();
        unit.move();
    }

}
