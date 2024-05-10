package fc.java.part2;

public class ArrayMake {
    public static void main(String[] args) {
        // Q. 정수 5개를 저장 할 배열을 생성하시요.
        int[] a = new int[5];
        a[0]=1;
        a[1]=2;
        a[2]=4;
        a[3]=6;
        a[4]=10;

//        System.out.println(a.length);
        for(int i=0; i<a.length; i++){
            a[i]=10;
        }

        for (int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }

        int[] b={10,20,30,40,50};

        for (int i=0; i < b.length; i++){
            System.out.println(b[i]);
        }

        // Q 정수 5개를 아래처럼 배열에 초기화 하고 index 0번째와 index 3번째 값을 더하여 출력하세요.






//        System.out.println("a = " + a[4]);
//        float[] f=new float[5];
//        fc.java.part2.Book[] b=new fc.java.part2.Book[3]; // 책 3권을 저장할 배열을 생성


    }
}
