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

    /**
     * Calculate the difference b/w this and given point.
     *
     * @param other point to calculate difference with
     * @return calculated difference
     */
    public Point diff(Point other) {
        int dx = x - other.getX();
        int dy = y - other.getY();
        return new Point(dx, dy);
    }

    /**
     * Calculate the sum of this and given point.
     *
     * @param other point to calculate sum with
     * @return calculated sum
     */
    public Point sum(Point other) {
        int dx = x + other.getX();
        int dy = y + other.getY();
        return new Point(dx, dy);
    }

    /**
     * Hash code for point.
     * 
     * @return unique hash code based on x and y-value
     */
    @Override
    public int hashCode() {
        return 97 * (97 * 3 + x) + y;
    }

    /**
     * Checks if x and y-values match with this.
     * 
     * @param obj comparable object
     * @return true if x and y-values are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

}
