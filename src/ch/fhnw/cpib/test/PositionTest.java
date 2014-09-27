package ch.fhnw.cpib.test;

import org.junit.Assert;
import org.junit.Test;

import ch.fhnw.cpib.lexing.Position;

public class PositionTest {

    @Test
    public void testNegativeValuesAllowed() {
        Position position = new Position(-1,-2,-3);
    }
    
    @Test
    public void testGetters() {
        Position p = new Position(1,2,3);
        Assert.assertEquals(1, p.getCurrentLine());
        Assert.assertEquals(2, p.getCurrentColumn());
        Assert.assertEquals(3, p.getCharacterPosition());
        
    }

}
