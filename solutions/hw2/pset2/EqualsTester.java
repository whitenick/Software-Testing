package pset2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
*
* @author  Cagdas Yelen
* @since   03-15-2017 
*/


public class EqualsTester {

    /*
     * P4: It is transitive: for any non-null reference values x, y and z,
     * if x.equals(y) returns true and y.equals(z) returns true, then
     * x.equals(z) should return true.
     */

    private boolean helper(Object obj1, Object obj2, Object obj3) {
        
        if (obj1.equals(obj2) && obj2.equals(obj3))
            return obj1.equals(obj3);
        return false;
    }



    @Test
    public void t1() {
        Object obj1 = new D("a",1);
        Object obj2 = new D("a",1);
        Object obj3 = new D("a",1);
        assertTrue(helper(obj1, obj2, obj3));
    }

    @Test
    public void t2() {
        Object obj1 = new C("a");
        Object obj2 = new D("a",1);
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t3() {
        Object obj1 = new Object();
        Object obj2 = new D("a",1);
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t4() {
        Object obj1 = new D("a",1);
        Object obj2 = new C("a");
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t5() {
        Object obj1 = new C("a");
        Object obj2 = new C("a");
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t6() {
        Object obj1 = new Object();
        Object obj2 = new C("a");
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t7() {
        Object obj1 = new D("a",1);
        Object obj2 = new Object();
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t8() {
        Object obj1 = new C("a");
        Object obj2 = new Object();
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t9() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new D("a",1);
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t10() {
        Object obj1 = new D("a",1);
        Object obj2 = new D("a",1);
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t11() {
        Object obj1 = new C("a");
        Object obj2 = new D("a",1);
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t12() {
        Object obj1 = new Object();
        Object obj2 = new D("a",1);
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t13() {
        Object obj1 = new D("a",1);
        Object obj2 = new C("a");
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t14() {
        Object obj1 = new C("a");
        Object obj2 = new C("a");
        Object obj3 = new C("a");
        assertTrue(helper(obj1, obj2, obj3));
    }

    @Test
    public void t15() {
        Object obj1 = new Object();
        Object obj2 = new C("a");
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t16() {
        Object obj1 = new D("a",1);
        Object obj2 = new Object();
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t17() {
        Object obj1 = new C("a");
        Object obj2 = new Object();
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t18() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new C("a");
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t19() {
        Object obj1 = new D("a",1);
        Object obj2 = new D("a",1);
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t20() {
        Object obj1 = new C("a");
        Object obj2 = new D("a",1);
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t21() {
        Object obj1 = new Object();
        Object obj2 = new D("a",1);
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t22() {
        Object obj1 = new D("a",1);
        Object obj2 = new C("a");
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
     public void t23() {
        Object obj1 = new C("a");
        Object obj2 = new C("a");
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t24() {
        Object obj1 = new Object();
        Object obj2 = new C("a");
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
     public void t25() {
        Object obj1 = new D("a",1);
        Object obj2 = new Object();
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t26() {
        Object obj1 = new C("a");
        Object obj2 = new Object();
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }

    @Test
    public void t27() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        assertFalse(helper(obj1, obj2, obj3));
    }
}
