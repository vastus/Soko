package vastus.sokoban.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Test class for Point.
 *
 * @author Juho Hautala
 */
public class PointTest {

    @Test
    public void getXShouldReturnXValue() {
        assertEquals(12, new Point(12, 0).getX());
    }

    @Test
    public void getYShouldReturnYValue() {
        assertEquals(32, new Point(-1, 32).getY());
    }

    @Test
    public void twoPointsWithSameValuesAreEqual() {
        assertEquals(new Point(12, 39), new Point(12, 39));
    }

    @Test
    public void twoPointsWithDifferentValuesAreNotSame() {
        assertFalse(new Point(-12, 3).equals(new Point(12, 39)));
    }

    @Test
    public void twoPointsWithDifferentXValuesAreNotSame() {
        assertFalse(new Point(12, 37).equals(new Point(-9, 37)));
    }

    @Test
    public void twoPointsWithDifferentYValuesAreNotSame() {
        assertFalse(new Point(-9, 37).equals(new Point(-9, 12)));
    }

    @Test
    public void equalsShouldReturnFalseWhenOtherObjectNull() {
        assertFalse(new Point(0, 0).equals(null));
    }

    @Test
    public void equalsShouldReturnFalseWhenOtherIsNotSameClass() {
        assertFalse(new Point(0, 0).equals(new Object()));
    }

    @Test
    public void twoPointsWithSameValuesShareSameHashCode() {
        assertEquals(new Point(11, 22).hashCode(), new Point(11, 22).hashCode());
    }

    @Test
    public void twoPointsWithDifferentValuesDontShareHashCode() {
        assertFalse(new Point(32, 48).hashCode() == new Point(0, 21).hashCode());
    }

    @Test
    public void shouldCalculateTheDifference() {
        assertEquals(new Point(0, 0), new Point(1, 1).diff(new Point(1, 1)));
        assertEquals(new Point(1, 0), new Point(2, 1).diff(new Point(1, 1)));
        assertEquals(new Point(0, 1), new Point(1, 2).diff(new Point(1, 1)));
        assertEquals(new Point(-1, 0), new Point(0, 1).diff(new Point(1, 1)));
        assertEquals(new Point(0, -1), new Point(1, 0).diff(new Point(1, 1)));
        assertEquals(new Point(1, 1), new Point(1, 1).diff(new Point(0, 0)));
    }

    @Test
    public void shouldCalculateTheSum() {
        assertEquals(new Point(2, 2), new Point(1, 1).sum(new Point(1, 1)));
        assertEquals(new Point(1, 0), new Point(1, 0).sum(new Point(0, 0)));
        assertEquals(new Point(1, 1), new Point(1, 0).sum(new Point(0, 1)));
        assertEquals(new Point(0, 0), new Point(1, 1).sum(new Point(-1, -1)));
        assertEquals(new Point(0, 0), new Point(-1, -1).sum(new Point(1, 1)));
    }

    @Test
    public void shouldPrintItself() {
        assertEquals("(234, -39)", new Point(234, -39).toString());
    }

}
