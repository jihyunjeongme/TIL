package fc.java.part2;

public class BookExam {
    public static void main(String[] args) {
        // Q. 한 권의 책 데이터를 저장하기 위해서 객체를 생성하시오. (인스턴스를 만드시오)
        Book b = new Book();
        b.title="자바";
        b.price=30000;
        b.company="Brian Comm";
        b.author="Jihyun";
        b.page=700;
        b.isbn="00700";
        System.out.println(b.title+"\t"+b.price+"\t"+b.company);
    }
}
