package pset1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pset1.SLList.Node;

public class SLListRepOkTester {
    @Test public void t0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
    }

    @Test public void t1() {
        //one node
        //repOk() test for true
        SLList l = new SLList();
        Node n = new Node();
        l.header = n;
        n.elem = true;
        n.next = null;
        assertTrue(l.repOk());
    }

    @Test public void t2() {
        //two nodes
        //repOk() test for true
        SLList l = new SLList();
        Node n = new Node();
        l.header = n;
        n.elem = true;
        Node nodeTwo = new Node();
        nodeTwo.elem = true;
        l.header.next = nodeTwo;
        assertTrue(l.header.elem == true);
        assertTrue(l.header.next != null);
        assertTrue(l.header.next.elem == true);
        assertTrue(l.header.next.next == null);
        assertTrue(l.repOk());
    }

    @Test public void t3() {
        //two nodes
        //repOk() test for false
        SLList l = new SLList();
        Node n = new Node();
        n.elem = true;
        l.header = n;
        Node nodeTwo = new Node();
        nodeTwo.elem = false;
        nodeTwo.next = l.header;
        n.next = nodeTwo;
        assertFalse(l.repOk());

    }

    @Test public void t4() {
        //one node
        //repOk() test for false
        SLList l = new SLList();
        Node n = new Node();
        l.header = n;
        l.header.elem = true;
        l.header.next = l.header;
        assertFalse(l.repOk());
    }
}
