package ch.fhnw.cpib;

import org.junit.Assert;
import org.junit.Test;

import ch.fhnw.cpib.lexing.Position;

public class PositionTest {

    @Test
    public void testNegativeValuesAllowed() {
        @SuppressWarnings("unused")
				Position position = new Position(-1, -2, -3);
    }

    @Test
    public void testGetters() {
        Position p = new Position(1, 2, 3);
        Assert.assertEquals(1, p.getCurrentLine());
        Assert.assertEquals(2, p.getCurrentColumn());
        Assert.assertEquals(3, p.getCharacterPosition());
    }

    @Test
    public void testCloneConstructor() {
        Position p = new Position(1, 2, 3);
        Position clone = new Position(p);

        Assert.assertNotSame(p, clone);
        Assert.assertEquals(p.getCurrentLine(), clone.getCurrentLine());
        Assert.assertEquals(p.getCurrentColumn(), clone.getCurrentColumn());
        Assert.assertEquals(p.getCharacterPosition(),
                clone.getCharacterPosition());
    }

    @Test
    public void testClone() {
        Position p = new Position(1, 2, 3);
        Position clone = p.clone();
        
        Assert.assertNotSame(p, clone);
        Assert.assertEquals(p.getCurrentLine(), clone.getCurrentLine());
        Assert.assertEquals(p.getCurrentColumn(), clone.getCurrentColumn());
        Assert.assertEquals(p.getCharacterPosition(),
                clone.getCharacterPosition());
    }

}
