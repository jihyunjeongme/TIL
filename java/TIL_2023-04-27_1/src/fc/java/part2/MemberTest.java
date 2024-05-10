package fc.java.part2;

public class MemberTest {
    public static void main(String[] args) {
        // Q. 한 명의 헬스클럽 회원 데이터를 저장하고 출력하시요.
        Member m = new Member();
        m.name="홍길동";
        m.age=30;
        m.tel="011-1111-1111";
        m.email="a@gmail.com";
        m.addr="서울";
        m.weight=70.0f;
        System.out.println(m.name+"\t"+m.age+"\t"+m.tel);


    }

}
