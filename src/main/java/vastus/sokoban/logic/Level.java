package vastus.sokoban.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describing a level of game.
 * Level keeps track of all the elements.
 * 
 * @author Juho Hautala
 */
public class Level {

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
    private final Map<Point, Element> elements;

    /**
     * TODO: ADD CONSTRUCTRORO!RO!O!OR!OR!R!OR!OR!OR!OR!O!R
     */
    public Level(int width, int height) throws Exception {
        checkDimensions(width, height);
        this.width = width;
        this.height = height;
        this.elements = null;
    }

    public Level(int width, int height, Map<Point, Element> elements)
            throws Exception {
        checkDimensions(width, height);
        this.width = width;
        this.height = height;
        this.elements = elements;
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
    public Map<Point, Element> getElements() {
        return elements;
    }

    protected static Level build(String s) throws Exception {
        String[] rows = Level.buildRows(s);
        Map<Point, Element> elems = Level.buildElements(rows);
        return new Level(rows[0].length(), rows.length, elems);
    }

    protected static Map<Point, Element> buildElements(String[] rows) throws Exception {
        Map<Point, Element> elements = new HashMap<>();
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[0].length(); x++) {
                char type = rows[y].charAt(x);
                elements.put(new Point(x, y), Element.build(type, x, y));
            }
        }
        
        return elements;
    }

    protected static String[] buildRows(String s) throws Exception {
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

}
