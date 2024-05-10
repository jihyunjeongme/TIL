package fc.java.part2;

import java.util.Scanner;

public class IfElseIfTest {
    public static void main(String[] args) {
        // 80점 이상의 학생 중에서 90점 이상은 A반, 85점 이상은 B반, 그렇지 않으면 C반으로 편성하고 점수가 80미만이면 불합격 처리하는 프로그램
        Scanner scan= new Scanner(System.in);
        System.out.println("학점을 입력하세요:");
        int score = scan.nextInt();

        if (score>=0 && score<=100) {
            if (score >= 90) {
                System.out.println("A반");
            } else if (score >= 85) {

            } else if (score >= 80){
                System.out.println("C반");
            } else {
                System.out.println("불합격");
            }
        }else {
            System.out.println("유효한 점수가 아닙니다.");
        }
    }
}
