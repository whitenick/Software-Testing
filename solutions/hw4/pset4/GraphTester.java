package pset4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class GraphTester {
    // tests for method "addEdge" in class "Graph"
    @Test
    public void tae0() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1]}");
    }

    // your tests for method "addEdge" in class "Graph" go here
    // you must provide at least 4 test methods;
    // each test method must have at least 1 invocation of addEdge;
    // each test method must have at least 1 test assertion;
    // your test methods must provide full statement coverage of your
    // implementation of addEdge and any helper methods
    // no test method directly invokes any method that is not
    // declared in the Graph class as given in this homework
    // tests for method "unreachable" in class "Graph"
    
    @Test
    public void tae1() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        assertEquals(g.toString(), "nodes=[0, 1, 2]; edges={0=[1], 1=[2]}");
    }
    
    @Test
    public void tae2() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        assertEquals(g.toString(), "nodes=[0, 1, 2, 3]; edges={0=[1], 1=[2, 3]}");
    }
    
    @Test
    public void tae3() {
        Graph g = new Graph();
        g.addEdge(0, 0);
        assertEquals(g.toString(), "nodes=[0]; edges={0=[0]}");
    }
    
    @Test
    public void tae4() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 1);
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1, 1]}");
    }
    
    @Test
    public void tr0() {
        Graph g = new Graph();
        g.addNode(0);
        Set<Integer> nodes = new HashSet<Integer>();
        nodes.add(0);
        assertTrue(g.unreachable(new HashSet<Integer>(), nodes));
    }
    // your tests for method "unreachable" in class "Graph" go here
    // you must provide at least 6 test methods;
    // each test method must have at least 1 invocation of unreachable;
    // each test method must have at least 1 test assertion;
    // at least 2 test methods must have at least 1 invocation of addEdge;
    // your test methods must provide full statement coverage of your
    // implementation of unreachable and any helper methods
    // no test method directly invokes any method that is not
    // declared in the Graph class as given in this homework
    
    @Test
    public void tr1() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        assertTrue(g.unreachable(new HashSet<>(Arrays.asList(0)), new HashSet<>(Arrays.asList(1))));
    }
    
    @Test
    public void tr2() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        assertFalse(g.unreachable(new HashSet<>(Arrays.asList(0, 1, 3)), new HashSet<>(Arrays.asList(1, 2))));
    }
    
    @Test
    public void tr3() {
        Graph g = new Graph();
        g.addNode(0);
        assertTrue(g.unreachable(new HashSet<>(Arrays.asList(0)), new HashSet<>()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void tr4() {
        Graph g = new Graph();
        g.unreachable(null, null);
    }
    
    @Test
    public void tr5() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        assertFalse(g.unreachable(new HashSet<>(Arrays.asList(0, 1, 3)), new HashSet<>(Arrays.asList(2, 4, 5))));
    }
    
    @Test
    public void tr6() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        assertTrue(g.unreachable(new HashSet<>(Arrays.asList(0, 1, 2)), new HashSet<>(Arrays.asList(3, 4, 5))));
    }
}