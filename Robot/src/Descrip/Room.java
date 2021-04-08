package Descrip;

import java.util.Objects;

public class Room {

    private final int width;
    private final int depth;

    public Room(int width, int depth) {
        if (width < 1 || depth < 1) {
            throw new IllegalArgumentException("Need value > 0 ");
        }

        this.width = width;
        this.depth = depth;
    }

    boolean isPositionValid(final Field field) {
        return field.getX() >= 0 && field.getX() <= width && field.getY() >= 0 && field.getY() <= depth;
    }

    Field getNeighbourField(final Field field, final Direction direction) {
        int x = field.getX();
        int y = field.getY();

        if (direction == Direction.N) {
            y--;
        } else if (direction == Direction.E) {
            x++;
        } else if (direction == Direction.S) {
            y++;
        } else if (direction == Direction.W) {
            x--;
        }

        final Field neighbourField = new Field(x, y);
        return isPositionValid(neighbourField) ? neighbourField : field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return width == room.width &&
                depth == room.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, depth);
    }
}
