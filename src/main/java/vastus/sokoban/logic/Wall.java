package vastus.sokoban.logic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Class describing a wall element.
 * 
 * @author Juho Hautala
 */
public class Wall extends Element {

    /**
     * Constructor for wall.
     *
     * @param position initial position of the wall
     */
    public Wall(Point position) {
        super(Element.WALL, position);
    }

    public void draw(Graphics g) {
        Shape wall = new Rectangle(getX() * SIZE, getY() * SIZE, SIZE, SIZE);
        g.setColor(new Color(96, 96, 102));
        g.fill(wall);
        g.setColor(new Color(76, 76, 82));
        g.draw(wall);
    }

}
