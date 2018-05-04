// nww295
package pset5;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;


public class GraphTester {
    // test method "addEdge"
    @Test
    public void tae0() {
        // initial given test
        Graph g = new Graph(2);
        g.addEdge(0,1);
        g.addEdge(1,0);
        //System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [true, false]]");
    }

    @Test
    public void tae1() {
        // test for graph with 3 nodes and 2 edges
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[false, true, false], [false, false, true], [false, false, false]]");
    }

    @Test
    public void tae2() {
        // test for graph with 4 nodes and 3 edges
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        assertEquals(g.toString(), "numNodes: 4\nedges: [[false, true, false, false], [false, false, true, false], [false, false, false, true], [false, false, false, false]]");
    }

    @Test
    public void tae3() {
        // test for graph with 1 node and a self edge
        Graph g = new Graph(1);
        g.addEdge(0,0);
        assertEquals(g.toString(), "numNodes: 1\nedges: [[true]]");
    }

    @Test (expected = IllegalArgumentException.class)
    public void tae4() {
        // test for graph with 2 nodes an an illegal addEdge w/ node value < 0
        Graph g = new Graph(2);
        g.addEdge(0,1);
        g.addEdge(-1, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tae5() {
        // test for graph with 2 nodes and an illegal addEdge w/ node value >= numNodes
        Graph g = new Graph(2);
        g.addEdge(0,1);
        g.addEdge(1,2);
    }

    // testing for reachable

    @Test
    public void tr0() {
        // test of graph size 1 testing single node reachable is true
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes,nodes));
    }

    @Test
    public void tr1() {
        // test of graph with 2 nodes and one edge and a return of true (direct reachability)
        Graph g = new Graph(2);
        g.addEdge(0,1);
        //g.addEdge(1,0);
        Set<Integer> sources = new TreeSet<>();
        sources.add(0);
        Set<Integer> targets = new TreeSet<>();
        targets.add(1);
        assertTrue(g.reachable(sources, targets));
    }

    @Test
    public void tr2() {
        // test of graph with 3 nodes and two edges and return of true
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(2,3);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(0);
        targets.add(2);
        targets.add(3);
        assertTrue(g.reachable(sources, targets));
    }

    @Test
    public void tr3() {
        // test of requirements for empty source set
        Graph g = new Graph(2);
        g.addEdge(0,1);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        targets.add(1);
        assertFalse(g.reachable(sources, targets));
    }

    @Test
    public void tr4() {
        // test of requirements for empty target set
        Graph g = new Graph(2);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(0);
        assertTrue(g.reachable(sources, targets));
    }

    @Test (expected = IllegalArgumentException.class)
    public void tr5() {
        // testing of reachable graph w/ 4 nodes and an indirect edge from node 0 to 3
        Graph g = new Graph(3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        Set<Integer> sources = null;
        Set<Integer> targets = null;
        boolean result = g.reachable(sources, targets);

    }

    @Test
    public void tr6() {
        // testing of illegal source node in set with value < 0
        Graph g = new Graph(3);
        g.addEdge(0,1);
        g.addEdge(0,2);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(-1);
        targets.add(1);
        assertFalse(g.reachable(sources, targets));
    }

    @Test
    public void tr7() {
        // testing of illegal target node in set with value > numNodes
        Graph g = new Graph(2);
        g.addEdge(0,1);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(0);
        targets.add(2);
        assertFalse(g.reachable(sources, targets));
    }


}
