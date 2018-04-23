// nww295

package pset5;

import java.util.*;

public class Graph {
    private int numNodes; //number of nodes in the graph
    private ArrayList<Integer> nodeList = new ArrayList<>();
    private boolean[][] edges;
    //edges[i][j] is true if and only if there is an edge from node i to node j
    // invariants: edges is non-null
    //              edges is a square matrix
    //              numNodes is number of rows in edges

    public Graph(int size) {
        numNodes = size;
        edges = new boolean[numNodes][numNodes];
        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges.length; j++) {
                edges[i][j] = false;
            }
        }
    }

    public String toString() {
        return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
    }

    public boolean equals(Object o) {
        if(o.getClass() != Graph.class) {
            return false;
        }

        return toString().equals(o.toString());
    }

    public void addEdge(int from, int to) {
        // postcondition: adds directed edge "from" -> "to" to this graph
        if(isValid(from) && isValid(to)) {
            edges[from][to] = true;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public boolean isValid(int node) {
        if(!(node < 0) && (node < numNodes)) {
            return true;
        }
        return false;
    }

    public boolean reachable(Set<Integer> sources, Set<Integer> targets) {

        if(sources == null || targets == null) {
            throw new IllegalArgumentException();
        }

        // (1) "sources" does not contain illegal node
        // (2) "targets" does not contain an illegal node
        // (3) for each node "m" in set "targets", there is some
        //  node "n" in set "sources" such that there is a directed
        //  path that starts at "n" and ends at "m" in "this"

        // target check
        for(Integer source: sources) {
            if(!(isValid(source))) {
                return false;
            }
        }

        // source check
        if(targets.isEmpty()) {
            return true;
        }
        for(Integer target: targets) {
            if(!(isValid(target))) {
                return false;
            }
        }

        // queue of nodes to explore. Pop the head.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> reached = new HashSet<>();
        for(Integer source: sources) {
            queue.add(source);
            if(targets.contains(source)) {
                reached.add(source);
            }
            while(!queue.isEmpty()) {
                int head = queue.remove();
                for(int i = 0; i < numNodes; i++) {
                    if(edges[head][i] == true) {
                        if(targets.contains(i)) {
                            reached.add(i);             // if node reached is also an element of targets, add to set
                        }
                        queue.add(i);
                    }
                }
            }
        }
        for(Integer target: targets) {
            if(!(reached.contains(target))) {
                return false;
            }
            return true;
        }
        return false;
    }
}
