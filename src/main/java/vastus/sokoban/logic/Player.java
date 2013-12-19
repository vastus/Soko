package vastus.sokoban.logic;

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

}
