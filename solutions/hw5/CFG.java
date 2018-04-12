package pset4;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import java.util.*;

/**
 * Created by Kaiyuan_Wang on 4/6/16.
 */
public class CFG {
    Set<Node> nodes = new HashSet<Node>();
    Map<Node, Set<Node>> edges = new HashMap<Node, Set<Node>>();

    public static class Node {
//        static final int dummyPos = -1;
        Node prev;
        int position;
        Method method;
        JavaClass clazz;

        Node (int p, Method m, JavaClass c) {
            position = p;
            method = m;
            clazz = c;
            prev = null;
        }

        Node (Node copy) {
            this.position = copy.position;
            this.method = copy.method;
            this.clazz = copy.clazz;
            this.prev = copy.prev;
        }

        public Method getMethod() {
            return method;
        }

        public JavaClass getClazz() {
            return clazz;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return (position == n.position) && method.equals(n.method) && clazz.equals(n.clazz);
        }

        public int hashCode() {
            return position + method.hashCode() + clazz.hashCode();
        }

        public String toString() {
            return clazz.getClassName() + "." + method.getName() + method.getSignature() + ": " + position;
        }

        public void printList() {
            Node current = this;
            StringBuilder sb = new StringBuilder();
            String suffix = "";
            while(current != null) {
                sb.insert(0, current.toString() + suffix);
                suffix = " -> ";
                current = current.prev;
            }
            System.out.println(sb.toString());
        }

        public boolean isStartOrEnd() {
            return position == 0 || position == -1;
        }

        public boolean isInvocationList() {
            List<Node> stack = new ArrayList<Node>();
            Node current = this;
            stack.add(0, current);
            Node prev = current.prev;
            if (prev.isStartOrEnd())
                stack.add(0, prev);
            while(prev != null) {
                if (!prev.method.equals(current.method)) {
                    if (current.position == 0) {
                        Node testNode = stack.get(0);
                        if (testNode.clazz.equals(current.clazz) && testNode.method.equals(current.method) && testNode.position == -1)
                            stack.remove(0);
                        else
                            stack.add(0, current);
                    }
                    if (prev.position == -1) {
                        stack.add(0, prev);
                    }
                }
                current = current.prev;
                prev = prev.prev;
            }
            for (Node n : stack) {
                if (n.position != 0)
                    return false;
            }
            return true;
        }
    }

    public void addNode(int p, Method m, JavaClass c) {
        addNode(new Node(p, m, c));
    }

    private void addNode(Node n) {
        nodes.add(n);
        Set<Node> nbrs = edges.get(n);
        if (nbrs == null) {
            nbrs = new HashSet<Node>();
            edges.put(n, nbrs);
        }
    }

    public void addEdge(int p1, Method m1, JavaClass c1, int p2, Method m2, JavaClass c2) {
        Node n1 = new Node(p1, m1, c1);
        Node n2 = new Node(p2, m2, c2);
        addNode(n1);
        addNode(n2);
        Set<Node> nbrs = edges.get(n1);
        nbrs.add(n2);
        edges.put(n1, nbrs);
    }

    public void addEdge(int p1, int p2, Method m, JavaClass c) {
        addEdge(p1, m, c, p2, m, c);
    }

    public String toString() {
        return nodes.size() + " nodes\n" + "nodes: " + nodes + "\n" + "edges: " + edges;
    }

    public void printCFG() {
        Map<Method, Set<Node>> clusters = new HashMap<Method, Set<Node>>();
        for (Node n : nodes) {
            if (!clusters.containsKey(n.getMethod())) {
                Set<Node> cluster = new HashSet<Node>();
                cluster.add(n);
                clusters.put(n.getMethod(), cluster);
            } else {
                Set<Node> cluster = clusters.get(n.getMethod());
                cluster.add(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Method, Set<Node>> entry : clusters.entrySet()) {
            sb.append("Method " + entry.getKey() + ":\n");
            List<Node> froms = new ArrayList<Node>(entry.getValue());
            Collections.sort(froms, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.position - o2.position;
                }
            });
            for (Node from : froms) {
                sb.append("    <" + from.toString() + "> -> <");
                String prefix = "";
                List<Node> tos = new ArrayList<Node>(edges.get(from));
                Collections.sort(tos, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.position - o2.position;
                    }
                });
                for (Node to : tos) {
                    sb.append(prefix + to.toString());
                    prefix = ", ";
                }
                sb.append(">\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean areEquivalent(CFG correctCFG, CFG suspiciousCFG) {
        List<Node> myExitNodeList = new ArrayList<Node>();
        List<Node> userDefExitNodeList = new ArrayList<Node>();
        // Check nodes
        if (!correctCFG.nodes.equals(suspiciousCFG.nodes)) {
            Map<Method, Set<Node>> correctClusters = new HashMap<Method, Set<Node>>();
            for (Node n : correctCFG.nodes) {
                if (!correctClusters.containsKey(n.getMethod())) {
                    Set<Node> cluster = new HashSet<Node>();
                    cluster.add(n);
                    correctClusters.put(n.getMethod(), cluster);
                } else {
                    Set<Node> cluster = correctClusters.get(n.getMethod());
                    cluster.add(n);
                }
            }
            Map<Method, Set<Node>> suspiciousClusters = new HashMap<Method, Set<Node>>();
            for (Node n : suspiciousCFG.nodes) {
                if (!suspiciousClusters.containsKey(n.getMethod())) {
                    Set<Node> cluster = new HashSet<Node>();
                    cluster.add(n);
                    suspiciousClusters.put(n.getMethod(), cluster);
                } else {
                    Set<Node> cluster = suspiciousClusters.get(n.getMethod());
                    cluster.add(n);
                }
            }
            if (!correctClusters.keySet().equals(suspiciousClusters.keySet()))
                return false;
            Node myExitNode = null;
            Node userDefExitNode = null;
            for (Method m : correctClusters.keySet()) {
                // find exit node
                int diffCount = 0;
                for (Node n : correctClusters.get(m)) {
                    if (n.position == -1) {
                        myExitNode = n;
                        myExitNodeList.add(n);
                        break;
                    }
                }
                for (Node n : suspiciousClusters.get(m)) {
                    if (!correctCFG.nodes.contains(n)) {
                        diffCount += 1;
                        userDefExitNode = n;
                        userDefExitNodeList.add(n);
                    }
                }
                if (diffCount != 1) {
                    return false;
                }
                Set<Node> myCopy = new HashSet<Node>(correctClusters.get(m));
                myCopy.remove(myExitNode);
                Set<Node> userCopy = new HashSet<Node>(suspiciousClusters.get(m));
                userCopy.remove(userDefExitNode);
                if (!myCopy.equals(userCopy)) {
                    return false;
                }
            }
        }

        // Check edges
        if (!correctCFG.edges.equals(suspiciousCFG.edges)) {
            for (Map.Entry<Node,Set<Node>> entry : suspiciousCFG.edges.entrySet()) {
                Set<Node> toRemove = new HashSet<Node>();
                Set<Node> toAdd = new HashSet<Node>();
                for (Node n : entry.getValue()) {
                    if (userDefExitNodeList.contains(n)) {
                        toRemove.add(n);
                        toAdd.add(myExitNodeList.get(userDefExitNodeList.indexOf(n)));
                    }
                }
                entry.getValue().removeAll(toRemove);
                entry.getValue().addAll(toAdd);
            }
            for (Node n :  userDefExitNodeList) {
                Set<Node> nodesFromUserDefExit = suspiciousCFG.edges.get(n);
                suspiciousCFG.edges.remove(n);
                suspiciousCFG.edges.put(myExitNodeList.get(userDefExitNodeList.indexOf(n)), nodesFromUserDefExit);
            }
            if (!correctCFG.edges.equals(suspiciousCFG.edges))
                return false;
        }
        return true;
    }

    public boolean isReachable(String methodFrom, String clazzFrom, String methodTo, String clazzTo) {
        Node from = null;
        Node to = null;
        // find initial instruction for both from and to methods
        for (Node node : nodes) {
            if (node.method.getName().equals(methodFrom) && node.clazz.getClassName().equals(clazzFrom) && node.position == 0)
                from = node;
            if (node.method.getName().equals(methodTo) && node.clazz.getClassName().equals(clazzTo) && node.position == 0)
                to = node;
        }
        if (from == null) {
//            System.err.println(clazzFrom + "." + methodFrom + " does not exist.");
            return false;
        }
        if (to == null) {
//            System.err.println(clazzTo + "." + methodTo + " does not exist.");
            return false;
        }

        Node fromCopy = new Node(from);

        Set<Node> visited = new HashSet<Node>();
        visited.add(fromCopy);

        LinkedList<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(fromCopy);

        while(!bfsQueue.isEmpty()) {
            Node currentCopy = bfsQueue.remove();
            for (Node next : edges.get(currentCopy)) {
                Node nextCopy = new Node(next);
                if (next.equals(to)) {
                    nextCopy.prev = currentCopy;
//                    nextCopy.printList();
                    return nextCopy.isInvocationList();
                }
                if (visited.add(nextCopy)) {
                    nextCopy.prev = currentCopy;
                    bfsQueue.add(nextCopy);
                }
            }
        }
        return false;
    }
}
