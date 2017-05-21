package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

/*
Thread can be created by extending Thread class. Thread can be started in constructor.
 */

class MyThreadFromThread2 extends Thread{

    public MyThreadFromThread2(String name) {
        super(name);
        start();        // Start thread in constructor
    }

    public void run(){
        String name = Thread.currentThread().getName();

        for(int i=0; i<10; i++){
            System.out.println(name);
        }
    }
}


public class MyThreadFromThreadTest2 {

    public static void main(String[] args){
        MyThreadFromThread2 t1 = new MyThreadFromThread2("Thread 1");
        MyThreadFromThread2 t2 = new MyThreadFromThread2("Thread 2");
    }

}
