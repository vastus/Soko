package vastus.sokoban.logic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Class describing movable box element.
 * 
 * @author Juho Hautala
 */
public class Box extends Movable {

    /**
     * Field for telling is box on storage or not.
     */
    private boolean onStorage;

    /**
     * Constructor for box by position. 
     * 
     * @param position initial position of box
     */
    public Box(Point position) {
        super(Element.BOX, position);
        this.onStorage = false;
    }

    /**
     * Constructor for box by position and storage.
     *
     * @param position initial position of box
     * @param onStorage boolean for box on storage
     */
    public Box(Point position, boolean onStorage) {
        super(Element.BOX_STORAGE, position);
        this.onStorage = onStorage;
    }

    /**
     * Tells if box is on storage place or not.
     *
     * @return true if on storage, false otherwise
     */
    public boolean isOnStorage() {
        return onStorage;
    }

    /**
     * Setter for onStorage.
     *
     * @param storage
     */
    public void setStorage(boolean storage) {
        this.onStorage = storage;
    }

    @Override
    public void draw(Graphics g) {
        Shape box = new Rectangle(getX() * SIZE, getY() * SIZE, SIZE, SIZE);
        g.setColor(new Color(204, 159, 97));
        g.fill(box);
        g.setColor(new Color(224, 180, 110));
        g.draw(box);
    }

}
