package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

/*
A thread can also be created by implementing runnable interface.
Implement runnable for the class whose instances are expected to be executed as thread.
Better way, as it decouples thread creation and thread responsibilities.
 */

class MyThreadFromRunnable implements Runnable{

    String name;

    public MyThreadFromRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(name);
        }
    }
}

public class MyThreadFromRunnableTest {

    public static void main(String[] args){
        MyThreadFromRunnable r1 = new MyThreadFromRunnable("Thread 1");
        MyThreadFromRunnable r2 = new MyThreadFromRunnable("Thread 2");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
