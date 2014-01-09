package vastus.sokoban.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describing a level of game.
 * Level keeps track of all the elements.
 * 
 * @author Juho Hautala
 */
public class Level implements ILevel {

    /**
     * Width of the level.
     */
    private final int width;

    /**
     * Height of the level.
     */
    private final int height;

    /**
     * Elements in level.
     */
    private List<Element> elems;

    /**
     * Movables in level.
     */
    private List<Movable> movabs;

    /**
     * Dummy constructor for tests.
     * 
     * @param width width of level
     * @param height height of level
     */
    public Level(int width, int height) throws Exception {
        checkDimensions(width, height);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor for level.
     * 
     * @param width width of level
     * @param height height of level
     * @param elements  elements of level
     * @param movables movables of level
     * @throws Exception 
     */

    public Level(int width, int height, List<Element> elements, List<Movable> movables)
            throws Exception {
        checkDimensions(width, height);
        this.width = width;
        this.height = height;
        this.elems = elements;
        this.movabs = movables;
    }

    /**
     * Getter for level width.
     * 
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for level height.
     * 
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for elements in level.
     * 
     * @return elements
     */
    public List<Element> getElements() {
        return elems;
    }

    /**
     * Getter for an element in given position.
     * 
     * @param position position to be fetched from.
     * @return found element at position or null
     */
    @Override
    public Element getElementAt(Point position) {
        for (Element element : elems) {
            if (element.getPosition().equals(position))
                return element;
        }

        return null;
    }

    /**
     * Getter for a movable in given position.
     *
     * @param position position to be fetched from.
     * @return found movable at position or null
     */
    @Override
    public Movable getMovableAt(Point position) {
        for (Movable movable : movabs) {
            if (movable.getPosition().equals(position))
                return movable;
        }

        return null;
    }

    /**
     * Getter for player in level.
     *
     * @return found player
     * @throws Exception when player not found
     */
    @Override
    public Player getPlayer() throws Exception {
        for (Movable movable : movabs)
            if (movable.getType() == Element.PLAYER)
                return (Player) movable;

        throw new Exception("Player not found.");
    }

    /**
     * Tells if given point is out of bounds.
     *
     * @param point point to check
     * @return true if point out of bounds false otherwise
     */
    @Override
    public boolean outOfBounds(Point point) {
        if (point.getX() < 0 || point.getX() >= width ||
                point.getY() < 0 || point.getY() >= height)
            return true;

        return false;
    }

    /**
     * Builds a new level from give string.
     * 
     * @param s string representation of level
     * @return new level
     * @throws Exception 
     */
    public static Level build(String s) throws Exception {
        if (!s.contains("@"))
            throw new Exception("No player in string.");

        String[] rows = Level.buildRows(s);
        List<Element> elems = Level.buildElements(rows);
        List<Movable> movabs = Level.buildMovables(rows);
        return new Level(rows[0].length(), rows.length, elems, movabs);
    }

    /**
     * Builds elements from given table of strings.
     * 
     * @param rows table of strings constructed from level string
     * @return a map of elements
     * @throws Exception 
     */
    public static List<Element> buildElements(String[] rows) throws Exception {
        List<Element> elements = new ArrayList<>();
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[0].length(); x++) {
                char type = rows[y].charAt(x);
                if (type == Element.FLOOR || type == Element.STORAGE || type == Element.WALL) {
                    elements.add(Element.build(type, x, y));
                } else if (type == Element.BOX_STORAGE) {
                    elements.add(Element.build(Element.STORAGE, x, y));
                }
            }
        }
        
        return elements;
    }

    public static List<Movable> buildMovables(String[] rows) throws Exception {
        List<Movable> movables = new ArrayList<>();
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[0].length(); x++) {
                char type = rows[y].charAt(x);
                if (type == Element.PLAYER || type == Element.BOX) {
                    movables.add((Movable) Element.build(type, x, y));
                } else if (type == Element.BOX_STORAGE) {
                    movables.add((Movable) Element.build(Element.BOX, x, y));
                }
            }
        }
        return movables;
    }

    /**
     * Builds a table of strings from given string and
     * checks that level string is in valid format.
     * 
     * @param s level string
     * @return table of strings
     * @throws Exception 
     */
    public static String[] buildRows(String s) throws Exception {
        s = s.trim();
        if (s == null || s.length() < 3)
            throw new Exception("Level string is not valid.");

        String[] rows = s.split("\n");
        for (int i = 1; i < rows.length; i++) {
            String row = rows[i-1];
            String next = rows[i];
            if (row.length() > 0 && (row.length() != next.length()))
                throw new Exception("Level string is not valid.");
        }

        return rows;
    }

    /**
     * Checks that dimensions are GTE 3.
     * 
     * @param width given width to constructor
     * @param height given height to constructor
     */
    private void checkDimensions(int width, int height) throws Exception {
        if ((width < 1 || height < 1) || (width < 3 && height < 3))
            throw new Exception("Width or height under required dimensions.");
    }

    @Override
    public String toString() {
        String lString = "";
        String s;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Element e = getElementAt(new Point(x, y));
                Movable m = getMovableAt(new Point(x, y));
                if (m == null && e == null) {
                    s = ".";
                } else if (m != null && e != null && m.getType() == Element.BOX && e.getType() == Element.STORAGE) {
                    s = "X";
                } else if (m != null) {
                    s = m.toString();
                } else {
                    s = e.toString();
                }
                lString += s;
            }
            lString += "\n";
        }
        return lString;
    }

}
