package Threads;

/**
 * Created by NISHANT on 4/1/18.
 */
public class EvenOddUsingWaitNotify {

    private static boolean odd = true;
    private static int count = 1;

    public static void main(String[] args) throws InterruptedException {

        EvenOddUsingWaitNotify evenOdd = new EvenOddUsingWaitNotify();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printOdd();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printEven();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }

    private void printOdd() {

        synchronized (this){
            while (count < 11){
                if (odd){
                        System.out.println(Thread.currentThread().getName() + " ODD " + count);
                        count++;
                        odd = false;
                        notify();
                }else {
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
            while (count < 11){
                if (!odd){
                        System.out.println(Thread.currentThread().getName() + " EVEN " + count);
                        count++;
                        odd = true;
                        notify();
                }else {
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
