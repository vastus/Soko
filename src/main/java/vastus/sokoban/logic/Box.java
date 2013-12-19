package vastus.sokoban.logic;

/**
 * Class describing movable box element.
 * 
 * @author Juho Hautala
 */
public class Box extends Movable {

    /**
     * Constructor for box with 
     * 
     * @param position initial position of box
     */
    public Box(Point position) {
        super(Element.BOX, position);
    }

}
