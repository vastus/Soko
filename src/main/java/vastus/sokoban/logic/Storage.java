package vastus.sokoban.logic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

/**
 * Class describing a storage element.
 * 
 * @author Juho Hautala
 */
public class Storage extends Element {

    public Storage(Point position) {
        super(Element.STORAGE, position);
    }

    @Override
    public void draw(Graphics g) {
        Shape storage = new Circle(getX() * SIZE + (SIZE/2), getY() * SIZE + (SIZE/2), SIZE/4);
        g.setColor(new Color(233, 118, 99));
        g.fill(storage);
        g.draw(storage);
    }

}
