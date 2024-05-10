package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Member;

public class GsonToJson {
    public static void main(String[] args) {
        Member mvo = new Member("홍길동",30,"stophhh@gmail.com");
        Gson gson = new Gson();

        String json = gson.toJson(mvo);
        System.out.println(json);



    }
}
