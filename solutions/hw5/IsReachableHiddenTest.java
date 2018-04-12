package pset4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class IsReachableHiddenTest {
    @Test(timeout=3000)
    public void testC1() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.C1");
        assertFalse(correctCFG.isReachable("max", "pset4.C1", "max", "pset4.C1"));
        assertFalse(correctCFG.isReachable("max", "pset4.C1", "avg", "pset4.C1"));
        assertFalse(correctCFG.isReachable("max", "pset4.C1", "mess", "pset4.C1"));
        assertFalse(correctCFG.isReachable("avg", "pset4.C1", "max", "pset4.C1"));
        assertFalse(correctCFG.isReachable("avg", "pset4.C1", "avg", "pset4.C1"));
        assertFalse(correctCFG.isReachable("avg", "pset4.C1", "mess", "pset4.C1"));
        assertFalse(correctCFG.isReachable("mess", "pset4.C1", "max", "pset4.C1"));
        assertFalse(correctCFG.isReachable("mess", "pset4.C1", "avg", "pset4.C1"));
        assertFalse(correctCFG.isReachable("mess", "pset4.C1", "mess", "pset4.C1"));

        assertFalse(correctCFG.isReachable("None", "pset4.C1", "None", "pset4.C1"));
    }

    @Test(timeout=3000)
    public void testC1Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.C1");
        assertFalse(correctCFG.isReachable(null, "pset4.C1", "max", "pset4.C1"));
        assertFalse(correctCFG.isReachable("max", "pset4.C1", null, "pset4.C1"));
        assertFalse(correctCFG.isReachable(null, "pset4.C1", null, "pset4.C1"));
    }

    @Test(timeout=3000)
    public void testC2() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.C2");
        assertFalse(correctCFG.isReachable("forloop", "pset4.C2", "forloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("forloop", "pset4.C2", "whileloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("forloop", "pset4.C2", "dowhileloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("whileloop", "pset4.C2", "forloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("whileloop", "pset4.C2", "whileloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("whileloop", "pset4.C2", "dowhileloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("dowhileloop", "pset4.C2", "forloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("dowhileloop", "pset4.C2", "whileloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("dowhileloop", "pset4.C2", "dowhileloop", "pset4.C2"));

        assertFalse(correctCFG.isReachable("None", "pset4.C2", "None", "pset4.C2"));
    }

    @Test(timeout=3000)
    public void testC2Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.C2");
        assertFalse(correctCFG.isReachable(null, "pset4.C2", "forloop", "pset4.C2"));
        assertFalse(correctCFG.isReachable("forloop", "pset4.C2", null, "pset4.C2"));
        assertFalse(correctCFG.isReachable(null, "pset4.C2", null, "pset4.C2"));
    }

    @Test(timeout=3000)
    public void testD1() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D1");
        assertFalse(correctCFG.isReachable("main", "pset4.D1", "main", "pset4.D1"));
        assertTrue(correctCFG.isReachable("main", "pset4.D1", "foo", "pset4.D1"));
        assertTrue(correctCFG.isReachable("main", "pset4.D1", "bar", "pset4.D1"));
        assertFalse(correctCFG.isReachable("foo", "pset4.D1", "main", "pset4.D1"));
        assertFalse(correctCFG.isReachable("foo", "pset4.D1", "foo", "pset4.D1"));
        assertTrue(correctCFG.isReachable("foo", "pset4.D1", "bar", "pset4.D1"));
        assertFalse(correctCFG.isReachable("bar", "pset4.D1", "main", "pset4.D1"));
        assertFalse(correctCFG.isReachable("bar", "pset4.D1", "foo", "pset4.D1"));
        assertFalse(correctCFG.isReachable("bar", "pset4.D1", "bar", "pset4.D1"));

        assertFalse(correctCFG.isReachable("None", "pset4.D1", "None", "pset4.D1"));
    }

    @Test(timeout=3000)
    public void testD1Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D1");
        assertFalse(correctCFG.isReachable(null, "pset4.D1", "foo", "pset4.D1"));
        assertFalse(correctCFG.isReachable("foo", "pset4.D1", null, "pset4.D1"));
        assertFalse(correctCFG.isReachable(null, "pset4.D1", null, "pset4.D1"));
    }

    @Test(timeout=3000)
    public void testD2() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D2");
        assertTrue(correctCFG.isReachable("a", "pset4.D2", "a", "pset4.D2"));
        assertTrue(correctCFG.isReachable("a", "pset4.D2", "b", "pset4.D2"));
        assertTrue(correctCFG.isReachable("b", "pset4.D2", "a", "pset4.D2"));
        assertTrue(correctCFG.isReachable("b", "pset4.D2", "b", "pset4.D2"));
    }

    @Test(timeout=3000)
    public void testD2Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.D2");
        assertFalse(correctCFG.isReachable(null, "pset4.D2", "a", "pset4.D2"));
        assertFalse(correctCFG.isReachable("a", "pset4.D2", null, "pset4.D2"));
        assertFalse(correctCFG.isReachable(null, "pset4.D2", null, "pset4.D2"));
    }

    @Test(timeout=3000)
    public void testE1() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E1");
        assertTrue(correctCFG.isReachable("foo", "pset4.E1", "foo", "pset4.E1"));
        assertTrue(correctCFG.isReachable("foo", "pset4.E1", "bar", "pset4.E1"));
        assertFalse(correctCFG.isReachable("foo", "pset4.E1", "x", "pset4.E1"));
        assertTrue(correctCFG.isReachable("bar", "pset4.E1", "foo", "pset4.E1"));
        assertTrue(correctCFG.isReachable("bar", "pset4.E1", "bar", "pset4.E1"));
        assertFalse(correctCFG.isReachable("bar", "pset4.E1", "x", "pset4.E1"));
        assertFalse(correctCFG.isReachable("x", "pset4.E1", "foo", "pset4.E1"));
        assertFalse(correctCFG.isReachable("x", "pset4.E1", "bar", "pset4.E1"));
        assertTrue(correctCFG.isReachable("x", "pset4.E1", "x", "pset4.E1"));

        assertFalse(correctCFG.isReachable("None", "pset4.E1", "None", "pset4.E1"));
    }

    @Test(timeout=3000)
    public void testE1Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E1");
        assertFalse(correctCFG.isReachable(null, "pset4.E1", "foo", "pset4.E1"));
        assertFalse(correctCFG.isReachable("foo", "pset4.E1", null, "pset4.E1"));
        assertFalse(correctCFG.isReachable(null, "pset4.E1", null, "pset4.E1"));
    }

    @Test(timeout=3000)
    public void testE2() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E2");
        assertTrue(correctCFG.isReachable("m1", "pset4.E2", "m1", "pset4.E2"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E2", "m2", "pset4.E2"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E2", "m3", "pset4.E2"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E2", "m1", "pset4.E2"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E2", "m2", "pset4.E2"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E2", "m3", "pset4.E2"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E2", "m1", "pset4.E2"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E2", "m2", "pset4.E2"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E2", "m3", "pset4.E2"));

        assertFalse(correctCFG.isReachable("None", "pset4.E2", "None", "pset4.E2"));
    }

    @Test(timeout=3000)
    public void testE2Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E2");
        assertFalse(correctCFG.isReachable(null, "pset4.E2", "m1", "pset4.E2"));
        assertFalse(correctCFG.isReachable("m1", "pset4.E2", null, "pset4.E2"));
        assertFalse(correctCFG.isReachable(null, "pset4.E2", null, "pset4.E2"));
    }

    @Test(timeout=3000)
    public void testE3() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E3");
        assertTrue(correctCFG.isReachable("m1", "pset4.E3", "m1", "pset4.E3"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E3", "m2", "pset4.E3"));
        assertFalse(correctCFG.isReachable("m1", "pset4.E3", "m3", "pset4.E3"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E3", "m1", "pset4.E3"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E3", "m2", "pset4.E3"));
        assertFalse(correctCFG.isReachable("m2", "pset4.E3", "m3", "pset4.E3"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E3", "m1", "pset4.E3"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E3", "m2", "pset4.E3"));
        assertTrue(correctCFG.isReachable("m3", "pset4.E3", "m3", "pset4.E3"));

        assertFalse(correctCFG.isReachable("None", "pset4.E3", "None", "pset4.E3"));
    }

    @Test(timeout=3000)
    public void testE3Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E3");
        assertFalse(correctCFG.isReachable(null, "pset4.E3", "m1", "pset4.E3"));
        assertFalse(correctCFG.isReachable("m1", "pset4.E3", null, "pset4.E3"));
        assertFalse(correctCFG.isReachable(null, "pset4.E3", null, "pset4.E3"));
    }

    @Test(timeout=3000)
    public void testE4() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E4");
        assertTrue(correctCFG.isReachable("m1", "pset4.E4", "m1", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E4", "m2", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E4", "m3", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E4", "m1", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E4", "m2", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m2", "pset4.E4", "m3", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m3", "pset4.E4", "m1", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m3", "pset4.E4", "m2", "pset4.E4"));
        assertTrue(correctCFG.isReachable("m3", "pset4.E4", "m3", "pset4.E4"));

        assertFalse(correctCFG.isReachable("None", "pset4.E4", "None", "pset4.E4"));
    }

    @Test(timeout=3000)
    public void testE4Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E4");
        assertFalse(correctCFG.isReachable(null, "pset4.E4", "m1", "pset4.E4"));
        assertFalse(correctCFG.isReachable("m1", "pset4.E4", null, "pset4.E4"));
        assertFalse(correctCFG.isReachable(null, "pset4.E4", null, "pset4.E4"));
    }

    @Test(timeout=3000)
    public void testE5() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E5");
        assertFalse(correctCFG.isReachable("m1", "pset4.E5", "m1", "pset4.E5"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E5", "m2", "pset4.E5"));
        assertTrue(correctCFG.isReachable("m1", "pset4.E5", "m3", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m2", "pset4.E5", "m1", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m2", "pset4.E5", "m2", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m2", "pset4.E5", "m3", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E5", "m1", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E5", "m2", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m3", "pset4.E5", "m3", "pset4.E5"));

        assertFalse(correctCFG.isReachable("None", "pset4.E5", "None", "pset4.E5"));
    }

    @Test(timeout=3000)
    public void testE5Null() throws ClassNotFoundException {
        CorrectGraphGenerator cgg = new CorrectGraphGenerator();
        CFG correctCFG = cgg.createCFGWithMethodInvocation("pset4.E5");
        assertFalse(correctCFG.isReachable(null, "pset4.E5", "m1", "pset4.E5"));
        assertFalse(correctCFG.isReachable("m1", "pset4.E5", null, "pset4.E5"));
        assertFalse(correctCFG.isReachable(null, "pset4.E5", null, "pset4.E5"));
    }
}
