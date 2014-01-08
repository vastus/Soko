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

    /*
    @Test
    public void shouldMoveToGivenPointAndSetNewPositionWhenStorage() throws Exception {
        Level level = Level.build("+O.@");
        Movable box = (Movable) level.getElementAt(new Point(1, 0));
        assertEquals(Element.BOX, box.getType());
        Point storagePosition = new Point(0, 0);
        assertEquals(Element.STORAGE, level.getElementAt(storagePosition).getType());
        //assertTrue(box.moveTo(storagePosition, level));
        //assertEquals(new Point(0, 0))
    }

    @Test
    public void shouldCollideWithWallAndNotSetPosition() throws Exception {
        Level level = Level.build("+O.@#");
        Movable player = level.getPlayer();
        Point currentPosition = player.getPosition();
        Point wallPosition = new Point(4, 0);
        assertFalse(player.moveTo(wallPosition, level));
        assertEquals(currentPosition, player.getPosition());
    }

    @Test
    public void shouldCollideWithBoxThatCannotBeMoved() throws Exception {
        Level level = Level.build("+#O@");
        Movable player = level.getPlayer();
        Point currentPosition = player.getPosition();
        Point boxPosition = new Point(2, 0);
        assertFalse(player.moveTo(boxPosition, level));
        assertEquals(currentPosition, player.getPosition());
    }

    @Ignore
    @Test
    public void shouldMoveToNewPositionWhenPushingAMovableBoxLeft() throws Exception {
        Level level = Level.build("+.O@");
        Movable player = level.getPlayer();
        Point prevBoxPosition = new Point(2, 0);
        Movable box = (Movable) level.getElementAt(prevBoxPosition);
        assertTrue(player.moveTo(box.getPosition(), level));
        assertEquals(prevBoxPosition, player.getPosition());
        assertEquals(new Point(1, 0), box.getPosition());
    }

    @Ignore
    @Test
    public void shouldMoveToNewPositionWhenPushingAMovableBoxRight() throws Exception {
        Level level = Level.build("@O.+");
        Movable player = level.getPlayer();
        Point prevBoxPosition = new Point(1, 0);
        Movable box = (Movable) level.getElementAt(prevBoxPosition);
        assertTrue(player.moveTo(new Point(1, 0), level));
        //assertEquals(prevBoxPosition, player.getPosition());
        //assertEquals(new Point(1, 0), box.getPosition());
    }
    */

}
