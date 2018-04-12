package pset5;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;


public class GraphTester {
    // test method "addEdge"
    @Test
    public void tae0() {
        Graph g = new Graph(2);
        g.addEdge(0,1);
        g.addEdge(1,0);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [true, false]]");
    }

    @Test
    public void tae1() {

    }

    @Test
    public void tae2() {

    }

    @Test
    public void tae3() {

    }

    @Test
    public void tae4() {

    }
}
