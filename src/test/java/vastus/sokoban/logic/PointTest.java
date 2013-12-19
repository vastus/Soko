package vastus.sokoban.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Point.
 *
 * @author Juho Hautala
 */
public class PointTest {
    
    @Before
    public void setUp() {}

    @Test
    public void getXShouldReturnXValue() {
        assertEquals(12, new Point(12, 0).getX());
    }

    @Test
    public void getYShouldReturnYValue() {
        assertEquals(32, new Point(-1, 32).getY());
    }
}