package vastus.sokoban.logic;

/**
 * Class for moving movables.
 *
 * @author Juho Hautala
 */
public class Mover {

    /**
     * Moves given movable to given point in level.
     * Checks bounds, collisions, and possible box moves.
     *
     * @param movable movable to move
     * @param to desired point to be moved to
     * @param level level to move in
     * @return true if valid move
     */
    public static boolean move(Movable movable, Point to, Level level) {
        if (level.outOfBounds(to))
            return false;

        Element elementAt = level.getElementAt(to);
        if (elementAt == null) {
            elementAt = new Floor(to);
        }

        if (elementAt.getType() == Element.WALL) {
            return false;
        }

        if (movable.getType() == Element.BOX && elementAt.getType() == Element.STORAGE) {
            Box box = (Box) movable;
            box.setStorage(true);
        } else if (movable.getType() == Element.BOX && elementAt.getType() != Element.STORAGE) {
            Box box = (Box) movable;
            box.setStorage(false);
        }

        Movable movableAt = level.getMovableAt(to);
        if (movableAt != null && movableAt.getType() == Element.BOX && movable.getType() == Element.PLAYER) {
            Point boxPos = movableAt.getPosition();
            Point playerPos = movable.getPosition();
            Point delta = boxPos.diff(playerPos);
            Point newBoxPos = boxPos.sum(delta);
            if (move(movableAt, newBoxPos, level)) {
                movable.setPosition(to);
                return true;
            }

            return false;
        }

        if (elementAt.getType() == Element.FLOOR || elementAt.getType() == Element.STORAGE) {
            movable.setPosition(to);
            return true;
        }

        return false;
    }

}
