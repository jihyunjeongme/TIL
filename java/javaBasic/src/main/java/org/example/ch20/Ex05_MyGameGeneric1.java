package org.example.ch20;

class Npc5 {
    @Override
    public String toString() {
        return "This is a Npc5.";
    }
}

class Tank5 {
    @Override
    public String toString() {
        return "This is a Tank5";
    }
}

class Camp5<T> {
    private T unit;

    public void set(T unit) {
        this.unit = unit;
    }

    public T getUnit() {
        return unit;
    }
}
public class Ex05_MyGameGeneric1 {

    public static void main(String[] args) {

        Camp5<Npc5> human = new Camp5<>();
        Camp5<Tank5> machine = new Camp5<>();

        human.set(new Npc5());
        machine.set(new Tank5());

        Npc5 unit = human.getUnit();
        Tank5 unit1 = machine.getUnit();

        System.out.println("unit = " + unit);
        System.out.println("unit1 = " + unit1);
    }
}
