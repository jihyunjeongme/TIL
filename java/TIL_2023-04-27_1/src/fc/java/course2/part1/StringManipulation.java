package fc.java.course2.part1;

public class StringManipulation {
    public static void main(String[] args) {
        String str="HelloWorld";

        char firstChar = str.charAt(0);
        System.out.println(firstChar);

        String replacedString = str.replaceAll("o","X");
        System.out.println(replacedString);

        int index = str.indexOf("W"); // 못 찾았을 경우 -1을 리턴해준다.
        System.out.println(index);

        int length = str.length();
        System.out.println(length);

        String upperCase = str.toUpperCase();
        System.out.println(upperCase);

        String lowerCase = str.toLowerCase();
        System.out.println(lowerCase);

        String substring = str.substring(5);
        System.out.println(substring);

        String substring2 = str.substring(5,8);
        System.out.println(substring2);

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));

        }






    }
}
