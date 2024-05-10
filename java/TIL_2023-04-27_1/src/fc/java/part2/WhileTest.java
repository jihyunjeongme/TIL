package fc.java.part2;

public class WhileTest {
    public static void main(String[] args) {
        // int[] numbers={1,2,3,4,5,6,7,8,9,10} 주어진 배열의 모든 원소를 출력하세요.

        int[] numbers={1,2,3,4,5,6,7,8,9,10};

//        int i=0;
//        while (i<numbers.length){
//            System.out.println(numbers[i]);
//            i++;
//        }

        // 1~10까지 출력하는 do-while문
        int i=0;
        do {
            System.out.println(numbers[i]);
            i++;
        }while(i<numbers.length);
    }
}
