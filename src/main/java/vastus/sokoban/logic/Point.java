package vastus.sokoban.logic;

/**
 * Class describing X and Y values in a level.
 * 
 * @author Juho Hautala
 */
public class Point {

    /**
     * The x-value of the point.
     */
    private final int x;

    /**
     * The y-value of the point.
     */
    private final int y;

    /**
     * Constructor for point.
     * 
     * @param x x-value of point
     * @param y y-value of point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x-value.
     * 
     * @return x-value
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y-value.
     * 
     * @return y-value
     */
    public int getY() {
        return y;
    }

}
