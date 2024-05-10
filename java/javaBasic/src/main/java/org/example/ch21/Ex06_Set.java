package org.example.ch21;

import java.util.HashSet;

public class Ex06_Set {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("orange");
        set.add("apple");
        set.add("banana");
        set.add("apple");

        System.out.println(set.size());


    }
}
