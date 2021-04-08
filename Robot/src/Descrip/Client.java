package Descrip;

import java.io.InputStream;
import java.util.Scanner;

class Client {

    static String processInput(final InputStream inputStream) {
        final var scanner = new Scanner(inputStream);

        System.out.println("Define the room size");
        final Room room = Parser.parseRoom(scanner.nextLine());

        System.out.println("Define the robot start position and start direction");
        final Robot robot = Parser.parseRobot(scanner.nextLine(), room);

        System.out.println("Define command sequence");
        final RobotController robotController = new RobotController(robot);
        scanner.nextLine().chars()
                .mapToObj(c -> (char) c)
                .forEach(robotController::executeCommand);

        return robot.toString();
    }
}
