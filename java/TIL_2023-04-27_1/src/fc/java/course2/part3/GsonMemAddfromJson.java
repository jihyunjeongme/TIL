package fc.java.course2.part3;

import com.google.gson.Gson;
import fc.java.model3.Person;

public class GsonMemAddfromJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"홍길동\",\"age\":30,\"email\":\"bit@gmail.com\",\"address\":{\"city\":\"서울\",\"country\":\"대한민국\"}}";

        Gson gson = new Gson();
        Person member = gson.fromJson(json, Person.class);
        System.out.println("member = " + member);

    }
}
