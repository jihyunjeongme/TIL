package org.example.ch14;

public class Ex04_concat {
    public static void main(String[] args) {
        String str1 = "기초";
        String str2 = "프로그래밍";

        String str3 = str1.concat(str2);
        System.out.println("str3 = " + str3);

        String str4 = "자바".concat(str3);
        System.out.println("str4 = " + str4);
    }
}
