package Descrip;

class RobotController {

    private final Robot robot;

    RobotController(final Robot robot) {
        this.robot = robot;
    }

    void executeCommand(final char command) {
        if ('R' == command) {
            robot.rotateRight();
        } else if ('L' == command) {
            robot.rotateLeft();
        } else if ('F' == command) {
            robot.moveForward();
        } else {
            throw new IllegalArgumentException(String.format("L,R,F ! only '%s' Unknown command ", command));
        }
    }
}
