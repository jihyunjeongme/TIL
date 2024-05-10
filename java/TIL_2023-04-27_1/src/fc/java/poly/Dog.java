package fc.java.poly;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("개처럼 먹다");
    }
    // 재정의를 하지 않음(x) --> 오류 입니다(재정의를 하세요)
//    public void eat(){
//        System.out.println("개처럼 먹다");
//    }
}
