package vastus.sokoban.logic;

/**
 * Class describing a wall element.
 * 
 * @author Juho Hautala
 */
public class Wall extends Element{

    public Wall(Point position) {
        super(Element.WALL, position);
    }

}
