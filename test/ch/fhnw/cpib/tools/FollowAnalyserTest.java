package ch.fhnw.cpib.tools;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.cpib.DragonGrammar;
import ch.fhnw.cpib.lexing.IEndMarker;
import ch.fhnw.cpib.parsing.IProductionNode;
import ch.fhnw.cpib.parsing.tools.FollowAnalyser;

public class FollowAnalyserTest {
    private DragonGrammar dragonGrammer;
    private FollowAnalyser analyser;

    @Before
    public void setup() {
        dragonGrammer = new DragonGrammar();
        analyser = new FollowAnalyser();
    }

    private boolean containsType(Set<IProductionNode> set,
            Class<? extends IProductionNode> type) {
        for (IProductionNode n : set) {
            if (type.isAssignableFrom(n.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testDragonE() {
        analyser.setGrammar(dragonGrammer);
        Set<IProductionNode> follow = analyser.follow(dragonGrammer.getE());
        Assert.assertNotNull(follow);
        Assert.assertEquals(2, follow.size());
        Assert.assertTrue(follow.contains(dragonGrammer.getBrClose()));
        Assert.assertTrue(containsType(follow, IEndMarker.class));
    }

    @Test
    public void testDragonEDash() {
        analyser.setGrammar(dragonGrammer);
        Set<IProductionNode> follow = analyser.follow(dragonGrammer.getEDash());
        Assert.assertNotNull(follow);
        Assert.assertEquals(2, follow.size());
        Assert.assertTrue(follow.contains(dragonGrammer.getBrClose()));
        Assert.assertTrue(containsType(follow, IEndMarker.class));
    }

    @Test
    public void testDragonT() {
        analyser.setGrammar(dragonGrammer);
        Set<IProductionNode> follow = analyser.follow(dragonGrammer.getT());
        Assert.assertNotNull(follow);
        Assert.assertEquals(3, follow.size());
        Assert.assertTrue(follow.contains(dragonGrammer.getPlus()));
        Assert.assertTrue(follow.contains(dragonGrammer.getBrClose()));
        Assert.assertTrue(containsType(follow, IEndMarker.class));
    }

    @Test
    public void testDragonTDash() {
        analyser.setGrammar(dragonGrammer);
        Set<IProductionNode> follow = analyser.follow(dragonGrammer.getTDash());
        Assert.assertNotNull(follow);
        Assert.assertEquals(3, follow.size());
        Assert.assertTrue(follow.contains(dragonGrammer.getPlus()));
        Assert.assertTrue(follow.contains(dragonGrammer.getBrClose()));
        Assert.assertTrue(containsType(follow, IEndMarker.class));
    }

    @Test
    public void testDragonF() {
        analyser.setGrammar(dragonGrammer);
        Set<IProductionNode> follow = analyser.follow(dragonGrammer.getF());
        Assert.assertNotNull(follow);
        Assert.assertEquals(4, follow.size());
        Assert.assertTrue(follow.contains(dragonGrammer.getTimes()));
        Assert.assertTrue(follow.contains(dragonGrammer.getPlus()));
        Assert.assertTrue(follow.contains(dragonGrammer.getBrClose()));
        Assert.assertTrue(containsType(follow, IEndMarker.class));
    }

}
