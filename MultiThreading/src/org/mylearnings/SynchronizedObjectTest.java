package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

class SynchronizedObject implements Runnable {

    Thread thread;
    String str1, str2;
    SharedClassSyncronized2 sharedObj;

    public SynchronizedObject(String str1, String str2, SharedClassSyncronized2 obj) {
        this.str1 = str1;
        this.str2 = str2;
        this.sharedObj = obj;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        synchronized (sharedObj) {
            sharedObj.display(str1, str2);
        }
    }
}

class SharedClassSyncronized2 {

    static void display(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(str2);
    }
}

public class SynchronizedObjectTest {
    public static void main(String[] args) {

        SharedClassSyncronized2 obj = new SharedClassSyncronized2();

        new SynchronizedObject("Hello", "World", obj);
        new SynchronizedObject("One", "Two", obj);
        new SynchronizedObject("Str1", "Str2", obj);
    }
}
