package fc.java.part2;

import java.util.Scanner;

public class IfbasicTest {
    public static void main(String[] args) {
        // 정수 1개를 입력 받아 입력된 수가 7의 배수인지 출력하세요.

//        int x = 8;
//        if((x % 7) == 0){
//            System.out.println("7의 배수입니다.");
//
//        }else {
//            System.out.println("7의 배수가 아닙니다.");
//        }

        Scanner scan=new Scanner(System.in);
        System.out.print("숫자를 입력하세요:");

        int title=scan.nextInt();

        if((title % 7) == 0){
            System.out.println("7의 배수입니다.");

        }else {
            System.out.println("7의 배수가 아닙니다.");
        }





    }
}
