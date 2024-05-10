package fc.java.part2;

import java.util.*;

public class ScannerTest {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

//        System.out.print("정수를 입력하세요:");
//        int num=scan.nextInt();
//        System.out.println("num = " + num);
//
//        System.out.print("실수를 입력하세요:");
//        float f=scan.nextFloat();
//        System.out.println("f = " + f);
        System.out.print("문자열 입력하세요:");
        String str1 = scan.next();
        System.out.println("str = " + str1);

        scan.nextLine();

        System.out.print("문자열 입력하세요:");
        String str2 = scan.nextLine();
        System.out.println("str = " + str2);

        scan.close();
    }
}
