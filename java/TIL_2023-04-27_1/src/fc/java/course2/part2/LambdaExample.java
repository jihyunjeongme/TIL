package fc.java.course2.part2;

import fc.java.model2.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {
//        MathOperation add = (int x, int y) -> { return x + y; };
        MathOperation add = (x, y) -> x+y;
        MathOperation multi = (x, y) -> x*y;

        System.out.println(add.operation(1,2));
        System.out.println(multi.operation(1,2));


    }

}
