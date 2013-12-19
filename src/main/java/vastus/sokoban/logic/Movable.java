package vastus.sokoban.logic;

/**
 * Abstract class describing movable elements in game.
 * Movable can be a player or box.
 * 
 * @author Juho Hautala
 */
public abstract class Movable extends Element {

    public Movable(char type, Point position) {
        super(type, position);
    }

}
