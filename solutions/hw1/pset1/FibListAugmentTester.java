package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class FibListAugmentTester {
    @Test
    public void test0() {
        FibList l = new FibList();
        assertTrue(l.repOk());
        l.augment();
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        
        assertTrue(l.size == 4);
        assertTrue(l.header.elem == 1);
        assertTrue(l.header.next != null);
        assertTrue(l.header.next.elem == 1);
        assertTrue(l.header.next.next != null);
        assertTrue(l.header.next.next.elem == 2);
        assertTrue(l.header.next.next.next != null);
        assertTrue(l.header.next.next.next.elem == 3);
        assertTrue(l.header.next.next.next.next == null);
    }

    @Test
    public void test1() {
        FibList l = new FibList();
        assertTrue(l.repOk());
        l.augment();
        assertTrue(l.repOk());
        l.augment();
        assertTrue(l.repOk());
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        
        assertTrue(l.size == 5);
        assertTrue(l.header.elem == 1);
        assertTrue(l.header.next != null);
        assertTrue(l.header.next.elem == 1);
        assertTrue(l.header.next.next != null);
        assertTrue(l.header.next.next.elem == 2);
        assertTrue(l.header.next.next.next != null);
        assertTrue(l.header.next.next.next.elem == 3);
        assertTrue(l.header.next.next.next.next != null);
        assertTrue(l.header.next.next.next.next.elem == 5);
        assertTrue(l.header.next.next.next.next.next == null);
    }
}
