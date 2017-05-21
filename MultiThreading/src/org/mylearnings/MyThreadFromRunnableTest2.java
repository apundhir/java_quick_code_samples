package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

class MyThreadFromRunnable2 implements Runnable{

    Thread t;

    public MyThreadFromRunnable2(String name) {
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i=0; i<10; i++){
            System.out.println(name);
        }
    }
}

public class MyThreadFromRunnableTest2 {
    public static void main(String[] args){
        new MyThreadFromRunnable2("Thread 1");
        new MyThreadFromRunnable2("Thread 2");
    }
}
