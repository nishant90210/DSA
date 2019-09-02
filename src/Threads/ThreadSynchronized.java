package Threads;

/**
 * Created by NISHANT on 4/5/18.
 */
public class ThreadSynchronized {

    private int count = 0;

    public static void main(String[] args) {

        ThreadSynchronized threadSynchronized = new ThreadSynchronized();
        threadSynchronized.doWork();
    }

    private synchronized void increment(){
        count++;
    }

    private void doWork() {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
//                    count++;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
//                    count++;
                    /* the reason for different answer some time, the reason is
                     * count++ is actually
                     * count = count + 1
                     * so the other thread takes the wrong value and store it back to count, so use a snychronized method for the
                     * increment*/
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();//This will make the main thread to wait for the other one to finish but still it does not guarantee
            t2.join();//correct execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is : " + count);
    }
}
