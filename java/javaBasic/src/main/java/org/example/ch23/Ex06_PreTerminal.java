package org.example.ch23;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Ex06_PreTerminal {
    public static void main(String[] args) {

        // 합
        int sum = IntStream.of(1, 3, 5, 7, 9)
                .sum();

        System.out.println("sum = " + sum);

        // 갯수
        long count = IntStream.of(1, 3, 5, 7, 9)
                .count();
        System.out.println("count = " + count);

        IntStream.of(1, 3, 5, 7, 9)
                .average()
                .ifPresent(avg -> System.out.println("avg = " + avg));


        IntStream.of(1,3,5,7,9)
                .min()
                .ifPresent(min -> System.out.println("min = " + min));

        IntStream.of(1,3,5,7,9)
                .max()
                .ifPresent(max -> System.out.println("max = " + max));
    }
}
