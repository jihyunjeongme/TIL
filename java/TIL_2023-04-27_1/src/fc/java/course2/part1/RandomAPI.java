package fc.java.course2.part1;

import java.util.Random;

public class RandomAPI {
    public static void main(String[] args) {
        Random rand=new Random();
        int[] arr=new int[6];
        int i=0;

        while (i<6){
            int num=rand.nextInt(45)+1;
            Boolean isDuplicate=false;

            // 배열의 이전 인덱스들과 비교하여 중복되는지 확인합니다.
            for (int j = 0; j < i; j++) {
                if(arr[j] == num){
                    System.out.println(arr[j]+"숫자가 앞의 숫자와 중복입니다.");
                    isDuplicate=true;

                    break;

                }
            }

            // 중복되지 않으면 배열에 추가합니다.
            if(!isDuplicate){
                arr[i++]=num;
            }
        }
        for (int num : arr){
            System.out.println(num+"");
        }
    }
}
