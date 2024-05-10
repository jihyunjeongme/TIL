package fc.java.model2;

public class ObjectArr<T> {
    private T[] arrary;
    private int size;

    public ObjectArr(int size){
        arrary = (T[])new Object[size];
    }

    public void set(int index, T value){
        arrary[index] = value;
        size++;
    }

    public T get(int index){
        return arrary[index];
    }

    public int size(){
        return size;
    }

}
