package vastus.sokoban.logic;

/**
 * Class describing floor element.
 * 
 * @author Juho Hautala
 */
public class Floor extends Element {

    /**
     * Constructor for floor.
     * 
     * @param position floor position
     */
    public Floor(Point position) {
        super(Element.FLOOR, position);
    }

}
