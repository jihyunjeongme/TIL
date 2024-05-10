package fc.java.part2;

public class ApiOverloading {
    public static void main(String[] args) {
        System.out.println();

        int max = maxValue(7, 9);
        System.out.println(max);

        int min = maxValue(3, 8);
        System.out.println(min);

    }

    // Q 두개의 정수를 매개변수로 받아서 더 큰수를 리턴하는 메서드를 정의하시오.
    public static int maxValue(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int minValue(int a, int b) {
        return (a < b) ? a : b;

    }
}
