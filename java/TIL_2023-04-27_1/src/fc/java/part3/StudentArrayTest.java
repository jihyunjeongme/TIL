package fc.java.part3;

import fc.java.model.StudentVO;

public class StudentArrayTest {
    public static void main(String[] args) {
        // Q. [객체배열]을 이용하여 4명의 학생(Student)데이터를 저장하고 출력하세요.
        StudentVO[] std= new StudentVO[4];
        std[0]=new StudentVO("홍길동","컴공1",33,"bit1@gmail.com",2023110,"010-1111-1111");
        std[1]=new StudentVO("나길동","컴공2",34,"bit2@gmail.com",2023111,"010-1111-1112");
        std[2]=new StudentVO("다길동","컴공3",35,"bit3@gmail.com",2023112,"010-1111-1113");
        std[3]=new StudentVO("라길동","컴공4",36,"bit4@gmail.com",2023113,"010-1111-1114");

//        for (int i = 0; i < std.length; i++) {
//            System.out.println(std[i].toString());
//        }

        for( StudentVO st : std){
            System.out.println(st.toString());
        }
    }
}
