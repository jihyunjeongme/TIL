package org.example.ch25;

public class Ex01_CurrentThread {
    public static void main(String[] args) {

        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);
    }
}
