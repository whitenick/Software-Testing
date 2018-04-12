package pset4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class CreateCFGWithMethodInvocationHiddenTest {
    @Test(timeout=3000)
    public void testD1() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D1");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFGWithMethodInvocation("pset4.D1");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }

    @Test(timeout=3000)
    public void testD2() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D2");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFGWithMethodInvocation("pset4.D2");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }

    @Test(timeout=3000)
    public void testD3() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D3");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFGWithMethodInvocation("pset4.D3");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }

    @Test(timeout=3000)
    public void testD4() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D4");
        GraphGenerator gg = new GraphGenerator();
        CFG suspiciousCFG = gg.createCFGWithMethodInvocation("pset4.D4");
        assertTrue(CFG.areEquivalent(correctCFG, suspiciousCFG));
    }
}
