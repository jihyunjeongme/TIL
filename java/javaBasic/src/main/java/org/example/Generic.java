package org.example;

class EmployeeInfo{
    public int rank;

    public EmployeeInfo(int rank) {
        this.rank = rank;
    }
}

class Person<T, S>{
    public T info;
    public S id;

    public Person(T info, S id) {
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println("info = " + info);
    }
}

public class Generic {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = 1;
        Person p1 = new Person(e,i);
        p1.printInfo(e);



//        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1),id);
//        System.out.println("p1 = " + p1);
//        System.out.println("p1 = " + p1.id.toString());



    }
}
