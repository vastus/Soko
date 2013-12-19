package vastus.sokoban.logic;

/**
 * Class describing a wall element.
 * 
 * @author Juho Hautala
 */
public class Wall extends Element{

    /**
     * Constructor for wall.
     *
     * @param position initial position of the wall
     */
    public Wall(Point position) {
        super(Element.WALL, position);
    }

}
