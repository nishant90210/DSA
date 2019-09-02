package Threads;

/**
 * Created by NISHANT on 4/6/18.
 */
public class ZeroEvenOdd {

    private static boolean odd = true;
    private static int state = 0;
    private static int count = 0;
    private static boolean lastRanEven = true;

    public static void main(String[] args) throws InterruptedException {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd();

        Thread t0 = new Thread(zeroEvenOdd::printZero);

        Thread t1 = new Thread(() -> zeroEvenOdd.printOdd());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                zeroEvenOdd.printEven();
            }
        });

        t0.start();
        Thread.sleep(1000);
        t1.start();
        Thread.sleep(1000);
        t2.start();

//        try {
//            t0.join();
//            t1.join();
//            t2.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }

    public void printZero() {

        synchronized (this){
            while (count < 10) {
                if (state == 0) {
                    // print
                    System.out.println(Thread.currentThread().getName() + " Zero " + 0);
                    count++;
                    if (lastRanEven) {
                        state = 1;
                    } else {
                        state = 2;
                    }
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printOdd() {

        synchronized (this) {
            while (count < 10) {
                if (state == 1) {
                    // print
                    System.out.println(Thread.currentThread().getName() + " Odd " + count);
                    state = 0;
                    lastRanEven = false;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void printEven() {

        synchronized (this){
            while (count < 10) {
                if (state == 2) {
                    // print
                    System.out.println(Thread.currentThread().getName() + " Even " + count);
                    state = 0;
                    lastRanEven = true;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
