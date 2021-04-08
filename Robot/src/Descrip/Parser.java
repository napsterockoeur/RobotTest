package Descrip;

import static java.util.Objects.requireNonNull;

class Parser {

    static Room parseRoom(final String parseString) {
        final String[] splitted = parseString.split(" ");
        if (splitted.length == 2) {
            final int x = Integer.parseInt(splitted[0]);
            final int y = Integer.parseInt(splitted[1]);
            return new Room(x, y);
        } else {
            throw new IllegalArgumentException("invalid parameters");
        }
    }

    static Robot parseRobot(final String parseString, final Room room) {
        final String[] splitted = parseString.split(" ");
        if (splitted.length == 3) {
            final int startX = Integer.parseInt(splitted[0]);
            final int startY = Integer.parseInt(splitted[1]);
            final Direction startDirection = Direction.valueOf(splitted[2]);
            return new Robot(requireNonNull(room), new Field(startX, startY), startDirection);
        } else {
            throw new IllegalArgumentException("invalid number of parameters.");
        }
    }
}
