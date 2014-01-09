package vastus.sokoban.logic;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for level.
 *
 * @author Juho Hautala
 */
public class LevelTest {

    @Test
    public void shouldGetWidth() throws Exception {
        Level level = new Level(3, 1);
        assertEquals(3, level.getWidth());
    }

    @Test
    public void shouldGetHeight() throws Exception {
        Level level = new Level(1, 3);
        assertEquals(3, level.getHeight());
    }

    @Test(expected=Exception.class)
    public void shouldThrowExceptionWhenWidth2() throws Exception {
        new Level(2, 2);
    }

    @Test(expected=Exception.class)
    public void shouldThrowExceptionWhenWidth0() throws Exception {
        new Level(0, 3);
    }

    @Test(expected=Exception.class)
    public void shouldThrowExceptionWhenWidthNegative() throws Exception {
        new Level(-1, 3);
    }

    @Test(expected=Exception.class)
    public void shoulThrowExceptionWhenHeight2() throws Exception {
        new Level(1, 2);
    }

    @Test(expected=Exception.class)
    public void shoulThrowExceptionWhenHeight0() throws Exception {
        new Level(3, 0);
    }

    @Test(expected=Exception.class)
    public void shoulThrowExceptionWhenHeightNegative() throws Exception {
        new Level(3, -1);
    }

    @Test
    public void shouldNotThrowExceptionWhenValidDimensions() throws Exception {
        new Level(3, 1); new Level(1, 3);
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenStringLengthIsNull() throws Exception {
        Level.buildRows(null);
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenStringLengthIs0() throws Exception {
        Level.buildRows("");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenStringLengthIs1() throws Exception {
        Level.buildRows("1");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenStringLengthIs2() throws Exception {
        Level.buildRows("12");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenStringLengthIsGTE3ButWhiteSpace()
            throws Exception {
        Level.buildRows("\n\n\n");
    }

    @Test
    public void buildRowsReturnsOneRowStringWithoutNewline() throws Exception {
        String[] expected = {"abc"};
        assertArrayEquals(expected, Level.buildRows("abc"));
    }

    @Test
    public void buildRowsReturnsOneRowStringWithOneNewline() throws Exception {
        String[] expected = {"abc"};
        assertArrayEquals(expected, Level.buildRows("abc\n"));
    }

    @Test
    public void buildRowsReturns3RowStringsWith2Newlines() throws Exception {
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, Level.buildRows("a\nb\nc"));
    }

    @Test
    public void buildRowsReturns3RowStringsWith3Newlines() throws Exception {
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, Level.buildRows("a\nb\nc\n"));
    }

    @Test
    public void buildRowsReturns3RowStringsWith3NewlinesAndExcessBefore()
            throws Exception {
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, Level.buildRows("\n\n\na\nb\nc"));
    }

    @Test
    public void buildRowsReturns3RowStringsWith3NewlinesAndExcessAfter()
            throws Exception {
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, Level.buildRows("a\nb\nc\n\n\n"));
    }

    @Test
    public void buildRowsReturns3RowStringsWith3NewlinesAndExcessBeforeNAfter()
            throws Exception {
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, Level.buildRows("\n\n\na\nb\nc\n\n\n"));
    }

    @Test
    public void buildRowsReturnsAnArrayOfStrings() throws Exception {
        String[] expected = {"abc", "def", "ghi"};
        assertArrayEquals(expected, Level.buildRows("abc\ndef\nghi"));
    }

    @Test
    public void buildRowsReturnsAnArrayOfStringsWithExcessNewlines()
            throws Exception {
        String[] expected = {"abc", "def", "ghi"};
        assertArrayEquals(expected, Level.buildRows("\n\nabc\ndef\nghi\n\n"));
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenRowLengthDoesntMatch()
            throws Exception {
        Level.buildRows("a\nab");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenRowLengthsDontMatchLonger()
            throws Exception {
        Level.buildRows("a\na\nbb\nbb");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenRowLengthsDontMatchShorter()
            throws Exception {
        Level.buildRows("aa\naa\nb");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhen2NewlinesInline()
            throws Exception {
        Level.buildRows("a\n\na");
    }

    @Test(expected=Exception.class)
    public void buildRowsThrowsExceptionWhenMultipleNewlinesInline()
            throws Exception {
        Level.buildRows("ab\n\n\nab");
    }

    @Test
    public void buildShouldSetTheWidthFromGivenString() throws Exception {
        Level one = Level.build("+\nO\n@\n");
        assertEquals(1, one.getWidth());
        Level three = Level.build("+O@");
        assertEquals(3, three.getWidth());
        Level four = Level.build("+.O@");
        assertEquals(4, four.getWidth());
    }

    @Test
    public void buildShouldSetTheHeightFromGivenString() throws Exception {
        Level one = Level.build("+O@");
        assertEquals(1, one.getHeight());
        Level three = Level.build("+\nO\n@\n");
        assertEquals(3, three.getHeight());
        Level four = Level.build("+\n.\nO\n@\n");
        assertEquals(4, four.getHeight());
    }

    @Test
    public void buildShouldSetWidthHeightFromGivenString() throws Exception {
        Level oneThree = Level.build("+\nO\n@");
        assertEquals(1, oneThree.getWidth());
        assertEquals(3, oneThree.getHeight());
        Level threeOne = Level.build("+O@");
        assertEquals(3, threeOne.getWidth());
        assertEquals(1, threeOne.getHeight());
    }

    @Test(expected=Exception.class)
    public void buildShouldThrowExceptionWhenNoPlayerInGivenString()
            throws Exception {
        Level.build("+O.");
    }

    @Test(expected=Exception.class)
    public void buildThrowsExceptionWhenGivenStringTooShort() throws Exception {
        Level.build("+O");
    }

    @Test(expected=Exception.class)
    public void buildThrowsExceptionWhenGivenStringTooShort2() throws Exception {
        Level.build("+\nO");
    }

    @Test(expected=Exception.class)
    public void buildThrowsExceptionWhenStringNull() throws Exception {
        Level.build(null);
    }

    @Test
    public void buildElementsReturnsMapOfElements() throws Exception {
        assertNotNull(Level.buildElements(new String[] {"+"}));
    }

    @Test
    public void buildElementsReturnsMatchingElementListByGivenRows()
            throws Exception {
        String[] rows = {"+O@", "+O."};
        List<Element> elements = Level.buildElements(rows);
        assertEquals(3, elements.size());
        assertEquals(Element.STORAGE, elements.get(0).getType());
        assertEquals(Element.STORAGE, elements.get(1).getType());
        assertEquals(Element.FLOOR, elements.get(2).getType());
    }

    @Test
    public void buildMovablesReturnsMatchingElementListByGivenRows()
            throws Exception {
        String[] rows = {"+O@", "+O."};
        List<Movable> movables = Level.buildMovables(rows);
        assertEquals(3, movables.size());
        assertEquals(Element.BOX, movables.get(0).getType());
        assertEquals(Element.PLAYER, movables.get(1).getType());
        assertEquals(Element.BOX, movables.get(2).getType());
    }

    @Test
    public void buildElementsAddsStorageToElementsListWhenGivenBoxStorage() 
            throws Exception {
        String[] rows = {"+O@", ".X."};
        List<Element> elements = Level.buildElements(rows);
        assertEquals(4, elements.size());
        assertEquals(Element.STORAGE, elements.get(0).getType());
        assertEquals(Element.FLOOR, elements.get(1).getType());
        assertEquals(Element.STORAGE, elements.get(2).getType());
        assertEquals(Element.FLOOR, elements.get(3).getType());
    }

    @Test
    public void buildMovablesAddsBoxToMovablesListWhenGivenBoxStorage()
            throws Exception {
        String[] rows = {"+O@", ".X."};
        List<Movable> movables = Level.buildMovables(rows);
        assertEquals(3, movables.size());
        assertEquals(Element.BOX, movables.get(0).getType());
        assertEquals(Element.PLAYER, movables.get(1).getType());
        assertEquals(Element.BOX, movables.get(2).getType());
    }

    @Test
    public void buildElementsReturnsMatchingListByTable2() throws Exception {
        String[] rows = {"++", "OO", "@."};
        List<Element> elements = Level.buildElements(rows);
        assertEquals(3, elements.size());
        assertEquals(Element.STORAGE, elements.get(0).getType());
        assertEquals(Element.STORAGE, elements.get(1).getType());
        assertEquals(Element.FLOOR, elements.get(2).getType());
    }

    @Test
    public void buildMovablesReturnsMatchingListByTable2() throws Exception {
        String[] rows = {"++", "OO", "@."};
        List<Movable> movables = Level.buildMovables(rows);
        assertEquals(3, movables.size());
        assertEquals(Element.BOX, movables.get(0).getType());
        assertEquals(Element.BOX, movables.get(1).getType());
        assertEquals(Element.PLAYER, movables.get(2).getType());
    }

    @Test
    public void buildShouldReturnNewLevelGivenAString() throws Exception {
        Level level = Level.build("+O@");
        assertEquals(3, level.getWidth());
        assertEquals(1, level.getHeight());
        assertNotNull(level.getElements());
        assertEquals(1, level.getElements().size());
    }

}
