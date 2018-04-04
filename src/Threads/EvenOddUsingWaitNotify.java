package Threads;

/**
 * Created by NISHANT on 4/1/18.
 */
public class EvenOddUsingWaitNotify {

    private  static boolean odd = true;
    private static int count = 1;

    public static void main(String[] args) throws InterruptedException {

        EvenOddUsingWaitNotify evenOdd = new EvenOddUsingWaitNotify();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printOdd();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void printEven() {

        synchronized (this){
            while (count < 10){
//                System.out.println("Inside print EVEN");
                while (odd){
                    try {
//                        System.out.println("Even waiting " + count);
                        wait();
//                        System.out.println("Notified Even :" + count);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Even Thread :" + count);
                count++;
                odd = true;
                notify();
            }
        }
    }

    public void printOdd() {

        synchronized (this) {
            while (count < 10) {
//                System.out.println("Inside print ODD");

                while (!odd) {
                    try {
//                        System.out.println("Odd waiting: " + count);
                        wait();
//                        System.out.println("Notified odd:" + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd thread :" + count);
                count++;
                odd = false;
                notify();

            }
        }
    }
}
