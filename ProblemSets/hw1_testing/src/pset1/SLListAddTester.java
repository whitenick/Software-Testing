package pset1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SLListAddTester {
    @Test public void test0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);

        // perform checks on the values for all fields of list and node objects reachable from l

        assertTrue(l.header != null);
        // my code
        assertTrue(l.header.elem == true);
        assertTrue(l.header.next == null);
        assertTrue(l.repOk());

    }

    @Test public void test1() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(true);
        assertTrue(l.repOk());
        l.add(false);
        assertTrue(l.repOk());

        // perform checks on the values for all the declared fields of list and node objects reachable from l

        assertTrue(l.header != null);
        //code here
        assertTrue(l.header.elem == false);
        assertTrue(l.header.next != null);
        assertTrue(l.header.next.elem == true);
        assertTrue(l.header.next.next == null);
    }


}
