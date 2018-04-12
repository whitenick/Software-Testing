package pset4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kaiyuan_Wang on 4/11/16.
 */
public class CreateCFGHiddenTest {
    @Test(timeout=3000)
    public void testC1() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFG("pset4.C1");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFG("pset4.C1");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }

    @Test(timeout=3000)
    public void testC2() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFG("pset4.C2");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFG("pset4.C2");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }
}
