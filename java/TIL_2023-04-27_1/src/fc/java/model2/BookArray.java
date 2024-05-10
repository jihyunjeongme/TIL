package fc.java.model2;

import java.util.Arrays;
import fc.java.model2.Book;

public class BookArray {
    private static final int DEFAULT_CAPACITY=5; // 수정불가(final)=> 상수
    private Book[] elements;
    private int size=0;

    // 생성동작
    public BookArray(){
        elements=new Book[DEFAULT_CAPACITY];
    }

    // 저장하는 동작
    public void add(Book element){
        // 크기 체크? if
        if(size==elements.length){
            ensureCapacity();
        }
        elements[size++]=element;
    }

    // 얻는 동작
    public Book get(int index){ // -1, 5~
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("인덱스의 범위를 넘었습니다");
        }
        // index 체크
        return elements[index];

    }

    // 원소의 개수를 넘겨주는 동작
    public int size(){
        return size;
    }

    public void ensureCapacity(){
        int newCapacity=elements.length*2;
        elements= Arrays.copyOf(elements,newCapacity);
    }
}
