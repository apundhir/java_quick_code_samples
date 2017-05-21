package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

/*
Thread group represents a group of threads. (Forms a tree structure)
A thread group can include another thread group.
A thread can access information about its own thread group only. (Not parent group or any other group)
 */

class SimpleThread extends Thread {

    public SimpleThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyThreadGroup {

    public static void main(String[] args) {

        // Starting threads, they should belongs to the same group
        new SimpleThread("A");
        new SimpleThread("B");

        // Get thread group of current thread
        ThreadGroup group = Thread.currentThread().getThreadGroup();

        // Get count of threads in this group
        System.out.println("Number of threads in current group:-" + group.activeCount());

        // Display name of all threads in this group
        Thread[] threads = new Thread[10];
        int size = group.enumerate(threads);
        for (int i = 0; i < size; i++) {
            System.out.println("Thread- " + threads[i].getName() + " Group Name- " + threads[i].getThreadGroup().getName());
        }
    }

}
