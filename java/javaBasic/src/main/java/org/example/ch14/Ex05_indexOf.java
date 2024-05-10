package org.example.ch14;

public class Ex05_indexOf {
    public static void main(String[] args) {

        String str = "AppleBananaOrange";
        int num1 = str.indexOf('A');

        int num2 = str.indexOf('A',num1+1);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }
}
