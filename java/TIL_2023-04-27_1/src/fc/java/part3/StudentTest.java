package fc.java.part3;

import fc.java.model.StudentVO;

public class StudentTest {
    public static void main(String[] args) {
        // 정수 6개를 저장할 배열을 생성하세요.

        int a[]=new int[6];
        a[0]=10;
        a[1]=11;
        a[2]=12;
        a[3]=13;
        a[4]=14;
        a[5]=15;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }



//        StudentVO s=new StudentVO("홍길동","컴퓨터공항",37,"bitcocom@empas.com",2023110,"010-1111-1111");
//        System.out.println(s);
    }
}
