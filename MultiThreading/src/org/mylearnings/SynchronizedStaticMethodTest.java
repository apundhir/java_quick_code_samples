package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

class SynchronizedStaticMethod implements Runnable {

    Thread thread;
    String str1, str2;

    public SynchronizedStaticMethod(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        SharedClassSyncronized.display(str1, str2);
    }
}

class SharedClassSyncronized {

    public synchronized static void display(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(str2);
    }
}

public class SynchronizedStaticMethodTest {

    public static void main(String[] args) {
        new SynchronizedStaticMethod("Hello", "World");
        new SynchronizedStaticMethod("One", "Two");
        new SynchronizedStaticMethod("Str1", "Str2");
    }
}
