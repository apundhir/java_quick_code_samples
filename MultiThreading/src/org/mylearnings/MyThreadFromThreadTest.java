package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

/*
Thread can be created by extending Thread class.
 */

class MyThreadFromThread extends Thread{

    public MyThreadFromThread(String name) {
        super(name);
    }

    public void run(){
        String name = Thread.currentThread().getName();

        for(int i=0; i<10; i++){
            System.out.println(name);
        }
    }
}

public class MyThreadFromThreadTest {

    public static void main(String[] args){

        MyThreadFromThread t1 = new MyThreadFromThread("Thread 1");
        MyThreadFromThread t2 = new MyThreadFromThread("Thread 2");

        t1.start();
        t2.start();

    }
}
