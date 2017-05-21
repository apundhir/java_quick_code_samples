package org.mylearnings;

/**
 * Created by apundhir on 21/05/17.
 */

/*
Producer consumer problem demonstrate Inter thread communication
 */

class SharedData {

    private int data;  // store shared data
    private boolean available;  // flag to tell if new data is available

    public synchronized int get() {
        while (!available) {
            // Data not available
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // consume data
        available = false;
        System.out.println(Thread.currentThread().getName() + " Consumed " + data);
        notifyAll();
        return data;
    }

    public synchronized void put(int data) {
        while (available) {
            // No place to put data
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        available = true;
        System.out.println(Thread.currentThread().getName() + " Produced " + data);
        notifyAll();
    }
}

class Producer extends Thread {

    private SharedData obj;

    public Producer(SharedData obj, String name) {
        super(name);
        this.obj = obj;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            obj.put(i);
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {

    private SharedData obj;

    public Consumer(SharedData obj, String name) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            obj.get();
        }
    }
}

public class ProducerConsumerTest {

    public static void main(String[] args) {
        SharedData obj = new SharedData();

        Producer producer = new Producer(obj, "producer");
        Consumer consumer = new Consumer(obj, "consumer");

        producer.start();
        consumer.start();

    }

}
