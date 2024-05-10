package fc.java.part2;

public class OverloadingTest {
    public static void main(String[] args) {
        // 매개변수로 두개의 정수 값을 받아서 총합을 구하여 리턴 하는 메서드를 정의 하세요.

        int a = 1;
        int b = 2;

        float c= 1.0F;
        float d=2.0F;

        int e=3;

        System.out.println(add(a,b));
        System.out.println(add(c,d));
        System.out.println(add(a,b,e));


        // 매개변수로 두 개의 실수 값을 받아서 총합을 구하여 리턴 하는 메서드를 정의 하세요.
    }
    public static int add(int a, int b){
        int sum=a+b;
        return sum;
    }

    public static float add(float a,float b){
        float sum=a+b;
        return sum;
    }

    public static int add(int a, int b, int c){
        int sum=a+b+c;
        return sum;
    }
}
