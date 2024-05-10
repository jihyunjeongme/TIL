package fc.java.part2;

public class PrePostOperTest {
    public static void main(String[] args) {
        // Q. 아래 증감 연산자의 출력문의 결과를 쓰시오
        int a=10;
        System.out.println("a = " + --a);
        System.out.println("a = " + a++);
        System.out.println("a = " + a--);
        System.out.println("a = " + ++a);
        System.out.println("a = " + a);

        // 9 9 10 10 10

    }
}
