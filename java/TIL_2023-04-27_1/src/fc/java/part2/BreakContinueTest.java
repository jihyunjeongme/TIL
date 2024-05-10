package fc.java.part2;

public class BreakContinueTest {
    public static void main(String[] args) {
        // char[] c={'s','h','u','t','d','o','w','n'}; 위 배열의 값을 출력 중 o를 만나면 반복을 중지하시오

//        char[] c={'s','h','u','t','d','o','w','n'};
//        for (int i = 0; i < c.length; i++) {
//            System.out.println("문자열:" +c[i]);
//            if (c[i]=='o') break;
//        }
        // 1~10까지의 수 중 3의 배수의 개수를 구하여 출력하시오.
        int cnt=0;
        for (int i = 1; i <= 10; i++) {
            if (i%3 !=0) continue;
                cnt++;
        }
        System.out.println(cnt);

    }
}
