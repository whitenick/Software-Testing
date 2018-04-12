package pset4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Integer> nodes; // set of nodes in the graph
    private Map<Integer, List<Integer>> edges;

    // map between a node and a list of nodes that are connected to it by
    // outgoing edges
    // class invariant: fields "nodes" and "edges" are non-null;
    // "this" graph has no node that is not in "nodes"
    public Graph() {
        nodes = new HashSet<Integer>();
        edges = new HashMap<Integer, List<Integer>>();
    }

    public String toString() {
        return "nodes=" + nodes + "; " + "edges=" + edges;
    }

    public void addNode(int n) {
        // postcondition: adds the node "n" to this graph
        nodes.add(n);
    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        // your code goes here
        // ...
        nodes.add(from);
        nodes.add(to);
        List<Integer> l = edges.get(from);
        if (l == null) {
            l = new LinkedList<>();
            edges.put(from, l);
        }
        l.add(to);
    }

    public boolean unreachable(Set<Integer> sources, Set<Integer> targets) {
        if (sources == null || targets == null)
            throw new IllegalArgumentException();
        // postcondition: returns true if (1) "sources" is a subset of "nodes",
        // (2) "targets" is
        // a subset of "nodes", and (3) for each node "m" in set "targets",
        // there is no node "n" in set "sources" such that there is a
        // directed path that starts at "n" and ends at "m" in "this"; and
        // false otherwise
        // your code goes here
        // ...
        if (!nodes.containsAll(sources) || !nodes.containsAll(targets)) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        for (int node : sources) {
            if (reachable(node, targets, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean reachable(int node, Set<Integer> targets, Set<Integer> visited) {
        if (!visited.add(node)) {
            return false;
        }
        if (targets.contains(node)) {
            return true;
        }
        if (edges.containsKey(node)) {
            for (int next : edges.get(node)) {
                if (reachable(next, targets, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
