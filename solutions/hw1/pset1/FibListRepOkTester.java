package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class FibListRepOkTester {
    @Test
    public void t0() {
        FibList l = new FibList();
        l.size = 0;
        assertFalse(l.repOk());
    }

    @Test
    public void t1() {
        FibList l = new FibList();
        l.header.next.next.next = l.header;
        l.header.elem = l.header.next.elem = l.header.next.next.elem = 0;
        assertFalse(l.repOk());
    }
    
    @Test
    public void t2() {
        FibList l = new FibList();
        l.header.next.next.elem = 3;
        assertFalse(l.repOk());
    }
    
    @Test
    public void t3() {
        FibList l = new FibList();
        assertTrue(l.repOk());
    }
}
