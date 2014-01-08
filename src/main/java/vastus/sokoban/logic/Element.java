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

    /**
     * Builds an element from given type and x and y-value.
     * 
     * @param type elements type
     * @param x elements initial x-value in position
     * @param y elements initial x-value in position
     * @return element of given type with position
     * @throws Exception 
     */
    public static Element build(char type, int x, int y) throws Exception {
        Point position = new Point(x, y);
        switch (type) {
        case Element.PLAYER:
            return new Player(position);
        case Element.BOX:
            return new Box(position);
        case Element.STORAGE:
            return new Storage(position);
        case Element.WALL:
            return new Wall(position);
        case Element.FLOOR:
            return new Floor(position);
        }

        throw new Exception(String.format("Type %c not found.", type));
    }

    @Override
    public String toString() {
        return String.format("%c", type);
    }

}
