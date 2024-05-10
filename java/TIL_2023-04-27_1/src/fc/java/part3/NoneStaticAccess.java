package fc.java.part3;

import fc.java.model.MyUtil;

public class NoneStaticAccess {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        // Myutil
        MyUtil my=new MyUtil();
        int sum=my.hap(a,b);
        System.out.println(sum);


    }
}
