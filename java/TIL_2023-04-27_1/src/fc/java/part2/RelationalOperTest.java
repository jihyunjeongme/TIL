package fc.java.part2;

public class RelationalOperTest {
    public static void main(String[] args) {
        int a = 4;
        System.out.println(a > 5); // F
        System.out.println(a < 5); // T
        System.out.println(a == 6); // F
        System.out.println(a != 4); // F
        System.out.println(3 >= a); // F
        System.out.println(a <= a+1); // T

    }
}
