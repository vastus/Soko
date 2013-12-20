package vastus.sokoban.logic;

/**
 * Interface for level.
 * 
 * @author Juho Hautala
 */
public interface ILevel {

    /**
     * Get an element at a specified position.
     * 
     * @param position position of the element to be returned
     * @return element at position if any, floor otherwise, null if out of bounds
     */
    Element getElementAt(Point position);

    /**
     * Tells if a specified point is out of bounds.
     * 
     * @param point point to compare
     * @return true if point is out of bounds
     */
    boolean outOfBounds(Point point);

}
