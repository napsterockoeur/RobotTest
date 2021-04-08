package Descrip;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Robot {

    private final Room room;
    private Field field;
    private Direction direction;

    public Robot(final Room room, final Field startField, final Direction startDirection) {
        this.room = requireNonNull(room);

        if (room.isPositionValid(startField)) {
            field = requireNonNull(startField);
        } else {
            throw new IllegalArgumentException("Startfield is outside room boundaries");
        }

        direction = requireNonNull(startDirection);
    }

    public void rotateLeft() {
        direction = direction.getLeft();
    }

    public void rotateRight() {
        direction = direction.getRight();
    }

    public void moveForward() {
        field = room.getNeighbourField(field, direction);
    }

    @Override
    public String toString() {
        return String.format("Report: %s %s", field, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(room, robot.room) &&
                Objects.equals(field, robot.field) &&
                direction == robot.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, field, direction);
    }
}
