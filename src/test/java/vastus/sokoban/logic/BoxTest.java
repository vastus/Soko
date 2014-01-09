package vastus.sokoban.logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Box.
 *
 * @author Juho Hautala
 */
public class BoxTest {

    @Test
    public void shouldNotBeOnStorageByDefault() {
        assertFalse(new Box(new Point(0, 0)).isOnStorage());
    }

    @Test
    public void shouldBeOnStorageWhenProvided() {
        assertTrue(new Box(new Point(0, 0), true).isOnStorage());
    }

}
