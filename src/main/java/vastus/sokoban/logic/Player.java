package vastus.sokoban.logic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Class describing a movable player element.
 * 
 * @author Juho Hautala
 */
public class Player extends Movable {

    /**
     * Constructor for player.
     * 
     * @param position initial position of player
     */
    public Player(Point position) {
        super(Element.PLAYER, position);
    }

    @Override
    public void draw(Graphics g) {
        Shape player = new Rectangle(getX() * SIZE + 4, getY() * SIZE + 4, SIZE - 8, SIZE - 8);
        g.setColor(Color.pink);
        g.fill(player);
        g.draw(player);
    }

}
