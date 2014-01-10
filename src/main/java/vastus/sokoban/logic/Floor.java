package vastus.sokoban.logic;

import org.newdawn.slick.Graphics;

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

    public void draw(Graphics g) {}

}
