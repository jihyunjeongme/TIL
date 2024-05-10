package org.example.ch15;

class BoxA1{

}

public class kEx01_ArrayInstance {
    public static void main(String[] args) {

        int[] ar1 = new int[5];
        double[] ar2 = new double[7];

        float[] ar3;
        ar3 = new float[9];

        BoxA1[] ar4 = new BoxA1[5];

        System.out.println("ar1 = " + ar1.length);
        System.out.println("ar2 = " + ar2.length);
        System.out.println("ar3 = " + ar3.length);
        System.out.println("ar4 = " + ar4.length);


    }
}
