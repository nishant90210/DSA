package Threads;

/**
 * Created by NISHANT on 4/25/18.
 */
//public class TrafficSignal {
//
//    public static void main(String[] args) {
//
//        TrafficSignalRunnable red = new TrafficSignalRunnable();
//        TrafficSignalRunnable green = new TrafficSignalRunnable();
//        TrafficSignalRunnable yellow = new TrafficSignalRunnable();
//
//        Thread t1 = new Thread(red, "red");
//        Thread t2 = new Thread(green, "green");
//        Thread t3 = new Thread(yellow, "yellow");
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//
//}

public class TrafficSignal {

    private String state = "Red";

    public void mainCode() {

        TrafficThread trafficThreadOne = new TrafficThread("Red");
        TrafficThread trafficThreadTwo = new TrafficThread("Yellow");
        TrafficThread trafficThreadThree = new TrafficThread("Green");

        trafficThreadOne.setPrevState(trafficThreadThree);
        trafficThreadOne.setNnState(trafficThreadTwo);

        trafficThreadTwo.setPrevState(trafficThreadOne);
        trafficThreadTwo.setNnState(trafficThreadThree);

        trafficThreadThree.setPrevState(trafficThreadTwo);
        trafficThreadThree.setNnState(trafficThreadOne);

        Thread threadOne = new Thread(trafficThreadOne);
        Thread threadTwo = new Thread(trafficThreadTwo);
        Thread threadThree = new Thread(trafficThreadThree);

        trafficThreadOne.setId(threadOne.getId());
        trafficThreadTwo.setId(threadTwo.getId());
        trafficThreadThree.setId(threadThree.getId());

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        synchronized (trafficThreadThree) {
            trafficThreadThree.notifyAll();
        }
    }

    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.mainCode();
    }


    class TrafficThread implements Runnable {

        private String nextState;

        private TrafficThread prevState;

        private TrafficThread nnState;

        private long id;

        public TrafficThread(String nextState) {
            this.nextState = nextState;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setPrevState(TrafficThread prevState) {
            this.prevState = prevState;
        }

        public void setNnState(TrafficThread nnState) {
            this.nnState = nnState;
        }

        public void run() {
            while(true) {
                synchronized (prevState) {
                    try {
                        prevState.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    state = nextState;
                    System.out.println("Thread"+id+"->"+state);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (nnState) {
                        nnState.notify();
                    }
                }
            }
        }
    }
}
