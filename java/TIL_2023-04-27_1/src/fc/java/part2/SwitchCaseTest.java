package fc.java.part2;

import java.util.Scanner;

public class SwitchCaseTest {
    public static void main(String[] args) {
        // switch ~ case 문을 활용하여 요일에 해당하는 운동을 출력하세요. (fc.java.part2.SwitchCaseTest.java)

        Scanner scan = new Scanner(System.in);
        System.out.print("요일을 입력하세요:");
        String day = scan.nextLine();

        switch (day) {
            case "Sunday":
                System.out.println("야구하기");
                break;
            case "Monday":
                System.out.println("농구하기");
                break;
            case "Tuesday":
                System.out.println("수영하기");
                break;
            case "Wednesday":
                System.out.println("수영하기");
                break;
            case "Friday":
                System.out.println("휴식");
                break;
            case "Saturday":
                System.out.println("휴식");
                break;

            default:
                System.out.println("요일을 잘못 입력했습니다");

        }
    }

}
