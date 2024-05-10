package org.example.ch21;

import java.util.HashMap;

public class Ex14_HashMap {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("홍길동","010-1234-1414");
        map.put("전우치","010-1123-1224");
        map.put("손오공","010-7774-7777");

        System.out.println(map.get("홍길동"));
        System.out.println(map.get("전우치"));
        System.out.println(map.get("손오공"));

        System.out.println();

        map.remove("손오공");
        System.out.println(map.get("손오공"));



    }
}
