package fc.java.part3;

public class StaticTest {
    public static void main(String[] args) {
        // Q. 매개변수로 2개의 정수를 입력받아서 총합을 구하여 리턴하는 [메서드를 정의] 하시요.
        int a=10;
        int b=20;

        int sum=StaticTest.hap(a,b);
        System.out.println(sum);
    }
    public static int hap(int a, int b){
        int v=a+b;
        return v;
    }
}
