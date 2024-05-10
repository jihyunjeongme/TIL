package org.example.ch21;

import java.util.*;

class StringDesc implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        return s2.compareTo(s1);
    }
}

public class Ex18_CollectionsSort2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "멀린");
        list = new ArrayList<>(list);

        // 오름차순
        Collections.sort(list);
        System.out.println("list = " + list);

        StringDesc cmp = new StringDesc();
        Collections.sort(list,cmp);
        System.out.println("list = " + list);

    }
}
