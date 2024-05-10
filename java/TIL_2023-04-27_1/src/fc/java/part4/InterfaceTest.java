package fc.java.part4;

import fc.java.poly.Radio;
import fc.java.poly.RemoCon;
import fc.java.poly.TV;

public class InterfaceTest {
    public static void main(String[] args) {
        RemoCon remo=new Radio();
        remo.chDown();
        remo.chUp();
        remo.volDown();
        remo.volUp();
//        remo.internet();

        remo=new TV();
        remo.chDown();
        remo.chUp();
        remo.volDown();
        remo.volUp();
//        remo.internet();

    }
}
