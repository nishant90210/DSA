//package DesignPatterns.Elevator;
//
//import com.sun.xml.internal.ws.api.pipe.Engine;
//import sun.management.Sensor;
//
//import java.util.Queue;
//
//// Handle elevator logic. Here the assumption is that the elevator has to come
//// back to ground floor if there are not any pending requests. There are two
//// queues which handles the floor requests, the elevator keeps moving in the
//// direction of the queue until that queue is not empty. If the elevator reaches
//// the top floor and there is no pending request then the elevator comes down to
//// ground floor and comes to the halting state.
//class Elevator {
//    public static final int MAX_WEIGHT_ALLOWED = 1600;
//
//    private final State state;
//    private final Door door;
//    private final Floor floor;
//    private final Queue<Floor> queueUp;
//    private final Queue<Floor> queueDown;
//    private final Engine engine;
//    private final Sensor sensor;
//    private final Alarm alarm;
//
//    Elevator(Door door, Engine engine, Sensor sensor, Alarm alarm) {
//        this.door  = door;
//        this.queueUp   = new Queue<Floor>();
//        this.queueDown = new Queue<Floor>();
//        this.state  = State.HALT;
//        this.floor  = Floor.GROUND;
//        this.engine = engine;
//        this.sensor = sensor;
//        this.alarm  = alarm;
//    }
//
//    public void stop() {
//        door.open();
//        state = State.HALT;
//        engine.stop();
//        System.out.println("Elevator is in stopped state.");
//    }
//
//    private void moveUp() {
//        while(!queueUp.isEmpty()) {
//            floor = queueUp.dequeue();
//            engine.moveTO(floor);
//        }
//        // All up requests are served.
//        state = state.DOWN;
//        gotoFloor(Floor.ZERO);
//    }
//
//    private void moveDown() {
//        while(!queueDown.isEmpty()) {
//            floor = queueUp.dequeue();
//            engine.moveTO(floor);
//        }
//        // All down requests served.
//        state = State.UP;
//    }
//
//    public void move() {
//        if (sensor.getWeight() > Elevator.MAX_WEIGHT_ALLOWED) {
//            alarm.ring();
//            stop();
//            return;
//        }
//        if (!sensor.shouldCloseDoor()) {
//            alarm.ring();
//            stop();
//            return;
//        }
//        door.close();
//        if (state == State.UP) {
//            moveUp();
//        } else if (state == State.DOWN) {
//            moveDOwn();
//        }
//        // Both the queues are empty
//        state = State.HALT;
//        System.out.println("Elevator is moving to floor: " + );
//    }
//
//    public void gotoFloor(Floor nextFloor) {
//        if (floor < nextFloor)
//            queueDown.enqueue(floor);
//        else
//            queueUp.enqueue(floor);
//        move();
//    }
//}
