package vastus.sokoban.logic;

/**
 * Abstract class describing movable elements in game.
 * Movable can be a player or box.
 *
 * @author Juho Hautala
 */
public abstract class Movable extends Element {

    /**
     * Constructor for movable.
     *
     * @param type type of element
     * @param position  initial position of element
     */
    public Movable(char type, Point position) {
        super(type, position);
    }

    public boolean moveUp(Level level) {
        return move(new Point(0, -1), level);
    }

    public boolean moveRight(Level level) {
        return move(new Point(1, 0), level);
    }

    public boolean moveDown(Level level) {
        return move(new Point(0, 1), level);
    }

    public boolean moveLeft(Level level) {
        return move(new Point(-1, 0), level);
    }

    private boolean move(Point delta, Level level) {
        Point wanted = getPosition().sum(delta);
        return Mover.move(this, wanted, level);
    }

}
