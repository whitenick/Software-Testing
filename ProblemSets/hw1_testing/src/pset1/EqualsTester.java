package pset1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EqualsTester {
    public Object object = new Object();
    public C newC = new C(4);
    public D newD = new D(2,4);

    // P1: for any non-null reference value x, x.equals(null) should return false
    @Test public void t0() {
        assertFalse(new Object().equals(null));
    }

    @Test public void t1() {
        assertFalse(newC.equals(null));
    }

    @Test public void t2() {
        assertFalse(newD.equals(null));
    }

    // P2: it is reflexive: for any non-null, x.equals(x) returns true

    @Test public void t3() {
        assertTrue(object.equals(object));
    }

    @Test public void t4() {
        assertTrue(newC.equals(newC));
    }

    @Test public void t5() {
        assertTrue(newD.equals(newD));
    }

    // P3: symmetric: for any non-null x and y, x.equals(y) returns true if y.equals(x) returns true
    @Test public void t6() {
        Object newObject = object;
        assertTrue(object.equals(newObject));
    }

    @Test public void t7() {
        assertFalse(object.equals(newC));
    }

    @Test public void t8() {
        assertFalse(object.equals(newD));
    }

    @Test public void t9() {
        C tempC = new C(4);
        assertTrue(newC.equals(tempC));
    }
    @Test public void t10() {
        assertFalse(newC.equals(object));
    }

    @Test public void t11() {
        assertFalse(newC.equals(newD));
    }

    @Test public void t12() {
        D tempD = new D(2,4);
        assertTrue(newD.equals(tempD));
    }
    @Test public void t13() {
        assertFalse(newD.equals(object));
    }

    @Test public void t14() {
        assertFalse(newD.equals(newC));
    }

}
