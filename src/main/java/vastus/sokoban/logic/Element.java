package vastus.sokoban.logic;

/**
 * Abstract class describing elements in game.
 * Element can be a player, box, storage or wall.
 * 
 * @author Juho Hautala
 */
public abstract class Element {

    /**
     * Character type of player.
     */
    public static final char PLAYER = '@';

    /**
     * Character type of box.
     */
    public static final char BOX = 'O';

    /**
     * Character type of storage.
     */
    public static final char STORAGE = '+';

    /**
     * Character type of wall.
     */
    public static final char WALL = '#';

    /**
     * Character type of floor.
     */
    public static final char FLOOR = '.';

    /**
     * Type of element.
     */
    private final char type;

    /**
     * Position of element.
     */
    private Point position;

    /**
     * Constructor for elements.
     * 
     * @param type type of element
     * @param position position of element
     */
    public Element(char type, Point position) {
        this.type = type;
        this.position = position;
    }

    /**
     * Getter for type.
     * 
     * @return type of element
     */
    public char getType() {
        return type;
    }

    /**
     * Getter for position.
     * 
     * @return position of element
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Setter for position.
     * 
     * @param position new position for element
     */
    public void setPosition(Point position) {
        this.position = position;
    }

}
