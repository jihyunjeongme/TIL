package fc.java.part2;

public class LoopLoopTest {
    public static void main(String[] args) {
        // 이중 반복문을 이용하여 아래와 같은 구구단(9X9)을 출력하세요.
        for (int i = 2; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                System.out.println(i+"단"+i+"X"+j+"="+i*j);

            }

        }
    }
}
