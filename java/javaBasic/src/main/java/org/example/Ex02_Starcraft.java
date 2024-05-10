package org.example;

abstract class Building
{
    int health;
    abstract void doBuild();
}

interface Fly
{
    void flyBuilding();
}

class Barracks extends Building implements Fly{
    @Override
    void doBuild() {
        System.out.println("인간형 유닛 생산 건물을 짓습니다.");
    }

    void doMakeMarine()
    {
        System.out.println("총 쏘는 유닛을 생산합니다.");
    }

    @Override
    public void flyBuilding() {
        System.out.println("건물이 날아서 이동하게 합니다.");

    }
}

public class Ex02_Starcraft {
    public static void main(String[] args) {

        Barracks barracks = new Barracks();
        barracks.doBuild();
        barracks.doMakeMarine();
        barracks.flyBuilding();
    }

}
