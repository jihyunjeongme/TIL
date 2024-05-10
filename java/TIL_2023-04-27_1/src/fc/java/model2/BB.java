package fc.java.model2;

// BB는 노출을 시킺 않는다.
public class BB implements CC{
    @Override
    public void x() {
        System.out.println("X 동작 실행");
    }

    @Override
    public void y() {
        System.out.println("Y 동작 실행");

    }

    @Override
    public void z() {
        System.out.println("Z 동작 실행");

    }
}
