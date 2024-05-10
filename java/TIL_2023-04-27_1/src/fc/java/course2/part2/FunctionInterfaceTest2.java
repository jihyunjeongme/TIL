package fc.java.course2.part2;

import fc.java.model2.MathOperation;
import fc.java.model2.MathOperationImpl;

public class FunctionInterfaceTest2 {
    public static void main(String[] args) {

        // MathOperation 인터페이스를 내부 익명 클래스로 구현해보자.
        MathOperation mo = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return x+y;
            }
        };
        int result = mo.operation(10,20);
        System.out.println(result);
    }
}
