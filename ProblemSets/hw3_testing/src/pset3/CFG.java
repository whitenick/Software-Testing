package pset3;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import java.util.*;

public class CFG {
	Set<Node> nodes = new HashSet<Node>();
	Map<Node, Set<Node>> edges = new HashMap<Node, Set<Node>>();

	public static class Node {
		int position;
		Method method;
		JavaClass clazz;

		Node(int p, Method m, JavaClass c) {
			position = p;
			method = m;
			clazz = c;
		}

		public Method getMethod() {
			return method;
		}

		public JavaClass getClazz() {
			return clazz;
		}

		public boolean equals(Object o) {
			if(!(o instanceof Node)) {
				return false;
			}

			Node n = (Node)o;
			return (position == n.position) && method.equals(n.method) && clazz.equals(n.clazz);
		}

		public int hashCode() {
			return position + method.hashCode() + clazz.hashCode();
		}

		public String toString() {
			return clazz.getClassName() + '.' + method.getName() + method.getSignature() + ": " + position;
		}
	}

	public static class Group<L, R> {
		public L left;
		public R right;

		public Group(L left, R right) {
			this.left = left;
			this.right = right;
		}

		public L left() {
			return this.left;
		}

		public R right() {
			return this.right;
		}
	}

	public void addNode(int p, Method m, JavaClass c) {
		addNode(new Node(p, m, c));
	}

	private void addNode(Node n) {
		nodes.add(n);
		Set<Node> nbrs = edges.get(n);
		if(nbrs == null) {
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

	public boolean isReachable(String methodFrom, String clazzFrom, String methodTo, String clazzTo) {
		Node begin = null;
		Node end = null;
		for(Node node: nodes) {
			if(node.method.getName().equals(methodTo) && node.clazz.getClassName().equals(clazzTo)) {
				if(node.position == 0) {
					end = node;
				}
			}
			if(node.method.getName().equals(methodFrom) && node.clazz.getClassName().equals(clazzFrom)) {
				if(node.position == 0) {
					begin = node;
				}
			}
		}
		if ((begin == null) || (end == null)) {
			return false;
		}

		// run a bfs
		Set<Node> blackNodes = new HashSet<Node>();
		blackNodes.add(begin);

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(begin);

		while(!queue.isEmpty()) {
			Node current = queue.remove();

			Set<Node> neighbors = edges.get(current);
			for(Node next: neighbors) {
				if(next.equals(end)) {
					return true;
				}
				if(blackNodes.add(next)) {
					queue.add(next);
				}
			}
		}
		return false;
	}
}
