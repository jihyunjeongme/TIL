package org.example.ch15;

public class Ex08_EnhancedFor {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        for (int e : arr) {
            System.out.println("e = " + e);
        }
        System.out.println();

        int sum = 0;

        // 배열 요소의 전체 합 출력
        for (int e : arr) {
            sum = sum + e;
        }
        System.out.println("sum = " + sum);
    }
}
