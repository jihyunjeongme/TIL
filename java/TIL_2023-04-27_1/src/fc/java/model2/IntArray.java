package fc.java.model2;

import java.util.Arrays;

public class IntArray {
    private static final int DEFAULT_CAPACITY=5; // 수정불가(final)=> 상수
    private int[] elements;
    private int size=0;

    // 생성동작
    public IntArray(){
        elements=new int[DEFAULT_CAPACITY];
    }

    // 저장하는 동작
    public void add(int element){
        // 크기 체크? if
        if(size==elements.length){
            ensureCapacity();
        }
        elements[size++]=element;
    }

    // 얻는 동작
    public int get(int index){ // -1, 5~
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
