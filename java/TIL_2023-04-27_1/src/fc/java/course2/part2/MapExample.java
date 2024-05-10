package fc.java.course2.part2;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();

        // 데이터 추가
        studentScores.put("Kim",95);
        studentScores.put("Lee",85);
        studentScores.put("Park",90);
        studentScores.put("Choi",80);

        // 데이터 조회
        System.out.println("Kim's score:" + studentScores.get("Kim"));
        System.out.println("Kim's score:" + studentScores.get("Lee"));

        // 데이터 수정
        studentScores.put("Kim",100);
        System.out.println(studentScores.get("Kim"));

        // 데이터 삭제
        studentScores.remove("Choi");
        System.out.println(studentScores.get("Choi"));

        // 전체 데이터 출력
        for(Map.Entry<String, Integer> entry : studentScores.entrySet()){
            System.out.println(entry.getKey()+ " "+entry.getValue());
        }
    }
}
