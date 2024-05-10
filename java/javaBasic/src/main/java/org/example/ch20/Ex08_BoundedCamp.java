package org.example.ch20;

class Camp8<T extends Number>
{
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}

public class Ex08_BoundedCamp {
    public static void main(String[] args) {

        Camp8<Integer> iBox = new Camp8<>();
        iBox.setOb(5);;

        Camp8<Double> dBox = new Camp8<>();
        dBox.setOb(5.97);

        System.out.println("dBox = " + dBox.getOb());
        System.out.println("iBox = " + iBox.getOb());
    }


}
