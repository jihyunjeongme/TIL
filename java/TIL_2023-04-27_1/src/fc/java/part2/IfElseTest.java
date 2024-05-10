package fc.java.part2;

import java.util.Scanner;

public class IfElseTest {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);

        System.out.println("정수를 입력하세요:");
        int n = scan.nextInt();
        if (n % 2 == 0) {
            System.out.println("짝수 입니다");

        }else {
            System.out.println("휼수 입니다");
        }

    }
}
