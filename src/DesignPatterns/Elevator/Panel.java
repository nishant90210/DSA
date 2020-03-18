//package DesignPatterns.Elevator;
//
//final class Panel {
//    private final Command[] commands;
//    private final Elevator elevator;
//
//    Panel(Command[] commands, Elevator elevator) {
//        this.commands = commands;
//        this.elevator = elevator;
//    }
//
//    public void onKeyPress(Command command) {
//        if (command == Command.OPEN) {
//            elevator.stop();
//        } else if (command == Command.CLOSE) {
//            elevator.move();
//        } else if (command == Command.GROUND) {
//            elevator.gotoFloor(Floor.GROUND);
//        } else if (command == Command.FIRST) {
//            elevator.gotoFloor(Floor.FIRST);
//        } else if (command == Command.SECOND) {
//            elevator.gotoFloor(Floor.SECOND);
//        }
//    }
//}
