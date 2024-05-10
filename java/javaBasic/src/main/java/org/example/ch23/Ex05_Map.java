package org.example.ch23;

import java.util.Arrays;
import java.util.List;

public class Ex05_Map {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");

        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(n -> System.out.print(n + "\t"));
    }
}
