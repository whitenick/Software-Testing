package pset1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HashCodeTester {
    /*
    P5: if two objects are equal according to the equals(Object) method, then
    calling the hashCode methon on each of the two objects must product the same integer
    result
     */
    public Object object = new Object();
    public C cObject = new C(4);
    public D dObject = new D(2,4);

    @Test public void t0() {
        Object tempO = object;
        assertTrue(object.hashCode() == tempO.hashCode());
    }

    @Test public void t1() {
        assertFalse(object.hashCode() == cObject.hashCode());
    }

    @Test public void t2() {
        assertFalse(object.hashCode() == dObject.hashCode());
    }

    @Test public void t3() {
        C tempC  = new C(4);
        assertTrue(cObject.hashCode() == tempC.hashCode());
    }

    @Test public void t4() {
        assertFalse(cObject.hashCode() == object.hashCode());
    }

    @Test public void t5() {
        assertFalse(cObject.hashCode() == dObject.hashCode());
    }

    @Test public void t6() {
        D tempD = new D(2,4);
        if(dObject.equals(tempD)) {
            assertTrue(dObject.hashCode() == tempD.hashCode());
        }

    }

    @Test public void t7() {
        assertFalse(dObject.hashCode() == object.hashCode());
    }

    @Test public void t8() {
        assertFalse(dObject.hashCode() == cObject.hashCode());
    }
}
