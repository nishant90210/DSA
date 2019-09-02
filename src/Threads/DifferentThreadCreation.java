package Threads;


public class DifferentThreadCreation {

}

    /*Java Thread Example by extending Thread class*/
class Multi extends Thread {

    public void run(){
        System.out.println("Thread is running..." + "Thread number " + this.getName());
    }
    public static void main(String args[]){
        Multi t1=new Multi();
        t1.start();
    }
}

    /*Java Thread Example by implementing Runnable interface*/
class Multi1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable thread is running..." + Thread.currentThread().getName());
        }

        public static void main(String args[]){
            Multi1 m1 = new Multi1();
            Thread t1 = new Thread(m1);
            t1.start();
        }
    }
