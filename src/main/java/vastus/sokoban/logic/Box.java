package vastus.sokoban.logic;

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

}
