package org.example;


import java.util.ArrayList;

public class ArraryListDemo {

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("three");

        for (int i = 0; i < al.size(); i++) {
            String value = al.get(i);
            System.out.println("value = " + value);

        }

    }

}
