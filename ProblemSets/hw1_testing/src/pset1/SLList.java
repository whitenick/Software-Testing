package pset1;

import java.util.HashSet;
import java.util.Set;

public class SLList {
    Node header;

    static class Node {
        boolean elem;
        Node next;
    }

    boolean repOk() {
        Set<Node> visited = new HashSet<Node>();
        Node n = header;
        while (n != null) {
            if (!visited.add(n)) {
                return false;
            }
            n = n.next;
        }
        return true;
    }

    void add(boolean e) {
        // add e in a new node at the beginning of the list; the rest of the list is unmodified

        Node newNode = new Node();
        newNode.elem = e;
        newNode.next = header;
        header = newNode;

    }


}
