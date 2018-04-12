package pset2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
*
* @author  Cagdas Yelen
* @since   03-15-2017 
*/


public class HashCodeTester {



    private boolean helper(Object obj1, Object obj2) {
        if (obj1.equals(obj2) || obj2.equals(obj1))
            return obj1.hashCode() == obj2.hashCode();
        return false;
    }

    @Test
    public void t1() {
        Object obj1 = new D("a",1);
        Object obj2 = new D("a",1);
        assertTrue(helper(obj1, obj2));
    }

    @Test
    public void t2() {
        Object obj1 = new D("a",1);
        Object obj2 = obj1;
        assertTrue(helper(obj1, obj2));
    }

    @Test
    public void t3() {
        Object obj1 = new C("a");
        Object obj2 = new C("a");
        assertTrue(helper(obj1, obj2));
    }

    @Test
    public void t4() {
        Object obj1 = new C("a");
        Object obj2 = obj1;
        assertTrue(helper(obj1, obj2));
    }

    @Test
    public void t5() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertTrue(helper(obj1, obj2));
    }
}
