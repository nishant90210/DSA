//package DesignPatterns.Elevator;
//
//final class Door {
//
//    private boolean final open;
//
//    Door() {
//        open = false;
//    }
//
//    public void open() {
//        if (open) return;
//        try {
//            Thread.sleep(1000); //1000 milliseconds is one second.
//            open = true;
//        } catch(InterruptedException ex) {
//            Thread.currentThread().interrupt();
//            close();
//        }
//    }
//
//    public void close() {
//        open = false;
//    }
//}
//
//
