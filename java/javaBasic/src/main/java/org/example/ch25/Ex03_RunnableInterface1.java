package org.example.ch25;

class MyThread3 implements Runnable
{
    public void run()
    {
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum = sum + i;
        String name = Thread.currentThread().getName();
        System.out.println("sum = " + sum);

    }
}

public class Ex03_RunnableInterface1 {
    public static void main(String[] args) {

        Thread t = new Thread(new MyThread3());
        t.start();
        System.out.println("Main: " + Thread.currentThread().getName());
    }
}
