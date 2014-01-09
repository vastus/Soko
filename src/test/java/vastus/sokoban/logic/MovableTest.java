package vastus.sokoban.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test class for movable.
 *
 * @author Juho Hautala
 */
public class MovableTest {

    @Test
    public void shouldMoveUpOnValidMove() throws Exception {
        Level level = Level.build(".\n@\nO\n+");
        Movable player = level.getPlayer();
        assertTrue(player.moveUp(level));
        assertEquals(new Point(0, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(0, 0)).getType());
        assertEquals(Element.PLAYER, level.getPlayer().getType());
        assertNull(level.getElementAt(new Point(0, 1)));
    }

    @Test
    public void shouldMoveRightOnValidMove() throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        assertTrue(player.moveRight(level));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.PLAYER, level.getPlayer().getType());
        assertNull(level.getElementAt(new Point(0, 0)));
    }

    @Test
    public void shouldMoveDownOnValidMove() throws Exception {
        Level level = Level.build("@\n.\nO\n+");
        Movable player = level.getPlayer();
        assertTrue(player.moveDown(level));
        assertEquals(new Point(0, 1), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(0, 1)).getType());
        assertEquals(Element.PLAYER, level.getPlayer().getType());
        assertNull(level.getElementAt(new Point(0, 0)));
    }

    @Test
    public void shouldMoveLeftOnValidMove() throws Exception {
        Level level = Level.build(".@O+");
        Movable player = level.getPlayer();
        assertTrue(player.moveLeft(level));
        assertEquals(new Point(0, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(0, 0)).getType());
        assertEquals(Element.PLAYER, level.getPlayer().getType());
        assertNull(level.getElementAt(new Point(1, 0)));
    }

    @Test
    public void shouldNotMoveOnInvalidMove() throws Exception {
        Level level = Level.build("#@O");
        Movable player = level.getPlayer();
        assertFalse(player.moveRight(level));
        assertFalse(player.moveUp(level));
        assertFalse(player.moveDown(level));
        assertFalse(player.moveLeft(level));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.PLAYER, level.getPlayer().getType());
    }

    @Test
    public void shouldMoveBox() throws Exception {
        Level level = Level.build("@O.");
        Movable player = level.getPlayer();
        assertTrue(player.moveRight(level));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(2, 0)).getType());
        assertNull(level.getMovableAt(new Point(0, 0)));
    }

    @Ignore
    @Test
    public void shouldMoveBoxToStorageOnMultipleMoves() throws Exception {
        Level level = Level.build("@O.+");
        Movable player = level.getPlayer();
        assertTrue(player.moveRight(level));
        assertNull(level.getMovableAt(new Point(0, 0)));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)));
        assertEquals(Element.BOX, level.getMovableAt(new Point(2, 0)));

        assertTrue(player.moveRight(level));
        assertNull(level.getMovableAt(new Point(0, 0)));
        assertNull(level.getMovableAt(new Point(1, 0)));
        assertEquals(new Point(2, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(2, 0)));
        assertEquals(Element.BOX, level.getMovableAt(new Point(3, 0)));
    }

}
