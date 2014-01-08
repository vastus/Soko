package vastus.sokoban.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test class for mover.
 *
 * @author Juho Hautala
 */
public class MoverTest {

    @Test
    public void shouldNotMoveOutfOfBounds() throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        assertFalse(Mover.move(player, new Point(-1, 0), level));
        assertFalse(Mover.move(player, new Point(0, -1), level));
        assertFalse(Mover.move(player, new Point(-1, -1), level));
        assertFalse(Mover.move(player, new Point(0, 1), level));
        assertFalse(Mover.move(player, new Point(4, 0), level));
        assertFalse(Mover.move(player, new Point(4, 1), level));
        assertFalse(Mover.move(player, new Point(4, -1), level));
    }

    @Test
    public void shouldMovePlayerToFloor() throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        assertTrue(Mover.move(player, new Point(1, 0), level));
    }

    @Test
    public void shouldMoveBoxToFloor() throws Exception {
        Level level = Level.build("@.O+");
        Movable box = level.getMovableAt(new Point(2, 0));
        assertTrue(Mover.move(box, new Point(1, 0), level));
    }

    @Test
    public void shouldMovePlayerToStorage() throws Exception {
        Level level = Level.build("@+.O");
        Movable player = level.getPlayer();
        assertTrue(Mover.move(player, new Point(1, 0), level));
    }

    @Test
    public void shouldMoveBoxToStorage() throws Exception {
        Level level = Level.build("@O+");
        Movable box = level.getMovableAt(new Point(1, 0));
        assertTrue(Mover.move(box, new Point(2, 0), level));
    }

    @Test
    public void shouldSetPlayersNewPositionOnValidMove() throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        Point newPos = new Point(1, 0);
        assertTrue(Mover.move(player, newPos, level));
        assertEquals(newPos, player.getPosition());
    }

    @Test
    public void shouldSetBoxesNewPositionOnValidMove() throws Exception {
        Level level = Level.build("@.O+");
        Movable box = level.getMovableAt(new Point(2, 0));
        Point newPos = new Point(3, 0);
        assertTrue(Mover.move(box, newPos, level));
        assertEquals(newPos, box.getPosition());
    }

    @Test
    public void shouldNotMovePlayerWhenNewPosIsBoxThatCannotBeMoved()
            throws Exception {
        Level level = Level.build(".@O");
        Movable player = level.getPlayer();
        Movable box = level.getMovableAt(new Point(2, 0));
        Point invalidPos = new Point(2, 0);
        assertFalse(Mover.move(box, new Point(3, 0), level));
        assertFalse(Mover.move(player, invalidPos, level));
    }

    @Test
    public void shouldNotMovePlayerToWall() throws Exception {
        Level level = Level.build("@#.O");
        Movable player = level.getPlayer();
        Point wallPos = new Point(1, 0);
        assertFalse(Mover.move(player, wallPos, level));
    }

    @Test
    public void shouldNotMoveBoxToWall() throws Exception {
        Level level = Level.build("@.O#");
        Movable box = level.getMovableAt(new Point(2, 0));
        Point wallPos = new Point(3, 0);
        assertFalse(Mover.move(box, wallPos, level));
    }

    @Test
    public void shouldNotUpdatePlayersPositionOnInvalidMove()
            throws Exception {
        Level level = Level.build("@#.O");
        Movable player = level.getPlayer();
        Point curPos = player.getPosition();
        Point wallPos = new Point(1, 0);
        assertFalse(Mover.move(player, wallPos, level));
        assertEquals(curPos, player.getPosition());
    }

    @Test
    public void shouldNotUpdatePlayersPositionOnInvalidMove2()
            throws Exception {
        Level level = Level.build("#@.O+");
        Movable player = level.getPlayer();
        Point from = player.getPosition();
        Point to = new Point(0, 0);
        assertFalse(Mover.move(player, to, level));
        assertEquals(player, level.getMovableAt(from));
        assertNull(level.getMovableAt(new Point(0, 0)));
    }

    @Test
    public void shouldNotUpdateBoxesPositionOnInvalidMove() throws Exception {
        Level level = Level.build("@O#");
        Movable box = level.getMovableAt(new Point(1, 0));
        Point curPos = box.getPosition();
        Point wallPos = new Point(2, 0);
        assertFalse(Mover.move(box, wallPos, level));
        assertEquals(curPos, box.getPosition());
    }

    @Test
    public void shouldRemovePlayersPreviousPositionOnValidMove()
            throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        Point from = player.getPosition();
        Point to = new Point(1, 0);
        assertTrue(Mover.move(player, to, level));
        assertNull(level.getMovableAt(from));
    }

    @Test
    public void shouldUpdatePlayersPositionOnValidMove()
            throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        Point from = player.getPosition();
        Point to = new Point(1, 0);
        assertTrue(Mover.move(player, to, level));
        assertNull(level.getMovableAt(from));
        assertEquals(level.getMovableAt(to), player);
    }

    @Test
    public void shouldRemoveBoxesPreviousPositionOnValidMove()
            throws Exception {
        Level level = Level.build("@.O+");
        Movable box = level.getMovableAt(new Point(2, 0));
        Point from = box.getPosition();
        Point to = new Point(3, 0);
        assertTrue(Mover.move(box, to, level));
        assertNull(level.getMovableAt(from));
    }

    @Test
    public void shouldUpdateBoxesPositionOnValidMove()
            throws Exception {
        Level level = Level.build("@.O+");
        Movable box = level.getMovableAt(new Point(2, 0));
        Point from = box.getPosition();
        Point to = new Point(3, 0);
        assertTrue(Mover.move(box, to, level));
        assertNull(level.getMovableAt(from));
        assertEquals(level.getMovableAt(to), box);
    }

    @Test
    public void shouldNotUpdateOrRemoveBoxesPositionOnInvalidMove()
            throws Exception {
        Level level = Level.build("@.O#+");
        Movable box = level.getMovableAt(new Point(2, 0));
        Point from = box.getPosition();
        Point to = new Point(3, 0);
        assertFalse(Mover.move(box, to, level));
        assertNull(level.getMovableAt(to));
        assertEquals(box, level.getMovableAt(from));
    }

    @Test
    public void shouldReturnFalseWhenCollidingWithBoxThatCannotBeMoved()
            throws Exception {
        Level level = Level.build(".@O");
        Movable player = level.getPlayer();
        assertFalse(Mover.move(player, new Point(2, 0), level));
        assertEquals(new Point(1, 0), player.getPosition());
    }

    @Test
    public void shouldNotUpdatePosWhenCollidingWithBoxThatCannotBeMoved() 
            throws Exception {
        Level level = Level.build(".@O");
        Movable player = level.getPlayer();
        assertFalse(Mover.move(player, new Point(2, 0), level));
        assertNull(level.getMovableAt(new Point(0, 0)));
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(2, 0)).getType());
    }

    @Test
    public void shouldReturnTrueWhenMovingABox()
            throws Exception {
        Level level = Level.build(".@O.+");
        Movable player = level.getPlayer();
        assertTrue(Mover.move(player, new Point(2, 0), level));
    }

    @Test
    public void shouldUpdatePositionsWhenMovingABox() throws Exception {
        Level level = Level.build(".@O+");
        Movable player = level.getPlayer();
        Movable box = level.getMovableAt(new Point(2, 0));
        assertTrue(Mover.move(player, new Point(2, 0), level));
        assertEquals(new Point(3, 0), box.getPosition());
        assertEquals(Element.BOX, level.getMovableAt(new Point(3, 0)).getType());
        assertEquals(new Point(2, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(2, 0)).getType());
        assertNull(level.getMovableAt(new Point(1, 0)));
    }

    @Test
    public void shouldUpdatePositionOnMultipleMoves() throws Exception {
        Level level = Level.build("@.+O");
        Movable player = level.getPlayer();
        assertTrue(Mover.move(player, new Point(1, 0), level));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(3, 0)).getType());
        assertNull(level.getMovableAt(new Point(0, 0)));

        assertTrue(Mover.move(player, new Point(2, 0), level));
        assertEquals(new Point(2, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(2, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(3, 0)).getType());
        assertNull(level.getMovableAt(new Point(0, 0)));
        assertNull(level.getMovableAt(new Point(1, 0)));
    }

    @Test
    public void shouldUpdateBothPositionsOnMultipleBoxMoves() throws Exception {
        Level level = Level.build("@.O+");
        Movable player = level.getPlayer();
        assertTrue(Mover.move(player, new Point(1, 0), level));
        assertEquals(new Point(1, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(1, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(2, 0)).getType());
        assertNull(level.getMovableAt(new Point(0, 0)));

        assertTrue(Mover.move(player, new Point(2, 0), level));
        assertEquals(new Point(2, 0), player.getPosition());
        assertEquals(Element.PLAYER, level.getMovableAt(new Point(2, 0)).getType());
        assertEquals(Element.BOX, level.getMovableAt(new Point(3, 0)).getType());
        assertNull(level.getMovableAt(new Point(0, 0)));
        assertNull(level.getMovableAt(new Point(1, 0)));
    }

}
