package Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadSync_AtomicExplained {

    public static void main(String[] args) {

        MyRunnable my1 = new MyRunnable();
        MyRunnable my2 = new MyRunnable();
        Thread t1 = new Thread(my1);
        Thread t2 = new Thread(my2);
        t1.start();
        t2.start();
    }


    static class MyRunnable implements Runnable {

        public static AtomicInteger atomicVal = new AtomicInteger(0);
        int counter = 0;
        @Override
        public void run() {

//            counter = atomicVal.incrementAndGet();
            counter++;
            System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + counter);
        }
    }
}
