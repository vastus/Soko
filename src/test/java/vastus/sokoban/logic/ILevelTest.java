package vastus.sokoban.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test class for ILevel.
 *
 * @author Juho Hautala
 */
public class ILevelTest {

    @Test
    public void getElementAtShouldReturnElementAtGivenPositionWhenExists()
            throws Exception {
        Level level = Level.build("+O@.");
        Element at = level.getElementAt(new Point(0, 0));
        assertNotNull(at);
        assertEquals(Element.STORAGE, at.getType());
        assertEquals(Element.FLOOR, level.getElementAt(new Point(3, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(1, 0)).getType());
        //assertEquals(Element.PLAYER, level.getElementAt(new Point(2, 0)).getType());
    }

    /*
    @Test
    public void setElementShouldSetGivenElementsPositionToPointAtGivenElement()
            throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        Point newPos = new Point(1, 0);
        assertEquals(Element.FLOOR, level.getElementAt(newPos).getType());
        player.setPosition(newPos);
        level.setElement(player);
        assertEquals(Element.PLAYER, level.getElementAt(newPos).getType());
    }
    */

    @Test
    public void outOfBoundsShouldReturnTrueWhenGivenPointOutSide()
            throws Exception {
        Level level = Level.build("+O@.");
        assertTrue(level.outOfBounds(new Point(-1, 0)));
        assertTrue(level.outOfBounds(new Point(0, -1)));
        assertTrue(level.outOfBounds(new Point(-1, -1)));
        assertTrue(level.outOfBounds(new Point(4, 0)));
        assertTrue(level.outOfBounds(new Point(0, 1)));
        assertTrue(level.outOfBounds(new Point(4, 1)));
    }

    @Test
    public void outOfBoundsShouldReturnTrueWhenGivenPointOutSide2()
            throws Exception {
        Level level = Level.build("+O@.\n+O..");
        assertTrue(level.outOfBounds(new Point(-1, 0)));
        assertTrue(level.outOfBounds(new Point(0, -1)));
        assertTrue(level.outOfBounds(new Point(-1, -1)));
        assertTrue(level.outOfBounds(new Point(level.getWidth(), 0)));
        assertTrue(level.outOfBounds(new Point(0, level.getHeight())));
        assertTrue(level.outOfBounds(new Point(level.getWidth(), level.getHeight())));
    }

    @Test
    public void outOfBoundsShouldReturnFalseWhenGivenPointInside()
            throws Exception {
        Level level = Level.build("+O@.");
        assertFalse(level.outOfBounds(new Point(0, 0)));
        assertFalse(level.outOfBounds(new Point(1, 0)));
        assertFalse(level.outOfBounds(new Point(2, 0)));
        assertFalse(level.outOfBounds(new Point(3, 0)));
    }

    @Test
    public void outOfBoundsShouldReturnFalseWhenGivenPointInside2()
            throws Exception {
        Level level = Level.build("+O@.\n+O..");
        assertFalse(level.outOfBounds(new Point(0, 0)));
        assertFalse(level.outOfBounds(new Point(1, 0)));
        assertFalse(level.outOfBounds(new Point(2, 0)));
        assertFalse(level.outOfBounds(new Point(3, 0)));
        assertFalse(level.outOfBounds(new Point(1, 1)));
        assertFalse(level.outOfBounds(new Point(2, 1)));
        assertFalse(level.outOfBounds(new Point(3, 1)));
    }

    @Test
    public void getPlayerShouldReturnPlayerInLevel() throws Exception {
        Level level = Level.build("+O@.");
        assertEquals(Element.PLAYER, level.getPlayer().getType());
    }

    @Test(expected=Exception.class)
    public void getPlayerShouldThrowExceptionWhenNotFound() throws Exception {
        Level level = Level.build("+O..");
        level.getPlayer();
    }

}
