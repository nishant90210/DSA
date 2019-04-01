package Threads;

import java.util.Scanner;

/**
 * Created by NISHANT on 4/5/18.
 */
public class BasicThreadSync {

    private static volatile boolean running = true;

    public static void main(String[] args) {

        BT bt = new BT();
        bt.start();

        System.out.println("Press Return key ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        bt.shutdown();

    }

    static class BT extends Thread{
        /* This Thread might decide to cache the value of 'running' and shutdown will never work, so make the variable volatile
         * so that it will never get cached in any version of java */
        public void run(){

            while (running){
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void shutdown(){

            running = false;
        }
    }
}
