package fc.java.poly;

public class TV implements RemoCon{
    @Override
    public void chUp() {
        System.out.println("TV 채널이 올라간다.");
    }

    @Override
    public void chDown() {
        System.out.println("TV 채널이 내려간다.");

    }

    @Override
    public void volUp() {
        System.out.println("TV 볼류이 올라간다.");

    }

    @Override
    public void volDown() {
        System.out.println("TV 보륨이 올라간다.");

    }

//    @Override
//    public void internet() {
//        super.internet();
//    }
    // chUp(), chDown(), volUp(), VolDown()

}
