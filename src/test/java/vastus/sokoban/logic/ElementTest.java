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
        assertEquals('X', Element.BOX_STORAGE);
    }

    @Test
    public void shouldGetType() {
        Point position = new Point(0, 0);
        assertEquals('@', new Player(position).getType());
        assertEquals('O', new Box(position).getType());
        assertEquals('+', new Storage(position).getType());
        assertEquals('#', new Wall(position).getType());
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

    @Test
    public void buildShouldReturnNewPlayerWithGivenTypeAndPosition() throws Exception {
        int x = 0, y = 0;
        Point position = new Point(x, y);
        Element element = Element.build('@', x, y);
        assertNotNull(element);
        assertEquals(Element.PLAYER, element.getType());
        assertEquals(position, element.getPosition());
    }

    @Test
    public void buildShouldReturnNewBoxWithGivenTypeAndPosition() throws Exception {
        int x = 0, y = 0;
        Point position = new Point(x, y);
        Element element = Element.build('O', x, y);
        assertNotNull(element);
        assertEquals(Element.BOX, element.getType());
        assertEquals(position, element.getPosition());
    }

    @Test
    public void buildShouldReturnNewStorageWithGivenTypeAndPosition() throws Exception {
        int x = 0, y = 0;
        Point position = new Point(x, y);
        Element element = Element.build('+', x, y);
        assertNotNull(element);
        assertEquals(Element.STORAGE, element.getType());
        assertEquals(position, element.getPosition());
    }

    @Test
    public void buildShouldReturnNewWallWithGivenTypeAndPosition() throws Exception {
        int x = 0, y = 0;
        Point position = new Point(x, y);
        Element element = Element.build('#', x, y);
        assertNotNull(element);
        assertEquals(Element.WALL, element.getType());
        assertEquals(position, element.getPosition());
    }

    @Test
    public void buildShouldReturnNewFloorWithGivenTypeAndPosition() throws Exception {
        int x = 0, y = 0;
        Point position = new Point(x, y);
        Element element = Element.build('.', x, y);
        assertNotNull(element);
        assertEquals(Element.FLOOR, element.getType());
        assertEquals(position, element.getPosition());
    }

    @Test(expected=Exception.class)
    public void buildShouldThrowExceptionWhenIncompatibleType() throws Exception {
        Element.build('N', 0, 0);
    }

    @Test
    public void shouldPrintItself() throws Exception {
        Element player = Element.build(Element.PLAYER, 0, 0);
        assertEquals("@", player.toString());
    }

}