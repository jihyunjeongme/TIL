package org.example.ch22;

interface Unit9
{
    int calc(int a, int b);
}

public class Ex09_LambdaRule2 {
    public static void main(String[] args) {
        Unit9 unit;

//        unit = (a, b) -> { return a + b; };

        unit = (a, b) -> a + b;


        int num = unit.calc(10, 20);
        System.out.println("num = " + num);

        unit = (a,b) -> a * b;
        System.out.println("unit = " + unit.calc(10, 20));

//        System.out.println("num = " + num);

    }
}
