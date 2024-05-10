package fc.java.part2;

public class MethodMakeTest {
    public static void main(String[] args) {
        // 매개변수로 2개의 정수를 받아서 총합을 구하여 리턴하는 메서드를 정의하시요
        int a=1;
        int b=2;
//        int result=0;
//        result=add(a,b);
        System.out.println(add(a,b));
    }

    public static int add(int a, int b){
        int sum=a+b;
        return sum;
    }
}
