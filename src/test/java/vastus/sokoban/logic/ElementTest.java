package vastus.sokoban.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Element.
 *
 * @author juhoh
 */
public class ElementTest {
    
    @Before
    public void setUp() {}

    @Test
    public void shouldKnowCharsForElements() {
        assertEquals('@', Element.PLAYER);
        assertEquals('O', Element.BOX);
        assertEquals('+', Element.STORAGE);
        assertEquals('#', Element.WALL);
        assertEquals('.', Element.FLOOR);
    }

    @Test
    public void shouldGetType() {
        Point position = new Point(0, 0);
        assertEquals('#', new Wall(position).getType());
        assertEquals('+', new Storage(position).getType());
    }

    @Test
    public void shouldGetPosition() {
        Element wall = new Wall(new Point(-12, 289));
        assertEquals(new Point(-12, 289), wall.getPosition());
    }

    @Test
    public void shouldSetPosition() {
        Point expected = new Point(43, 2);
        Element wall = new Wall(new Point(0, 0));
        wall.setPosition(new Point(43, 2));
        assertEquals(expected, wall.getPosition());
    }

}