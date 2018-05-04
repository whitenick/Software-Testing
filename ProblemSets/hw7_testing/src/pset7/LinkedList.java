package pset7;

// lecture 04/16, linked list testing direct verification vs. abstract non-deterministic

import static org.junit.Assert.*;



import java.util.HashSet;

import java.util.Set;



import org.junit.Test;



public class LinkedList {

	Node header;

	int size;



	static class Node {

		int elem;

		Node next;

	}



	boolean repOk() {

		if (header == null) return size == 0;

		Set<Node> visited = new HashSet<Node>();

		Node current = header;

		while (current != null) {

			if (!visited.add(current)) return false;

			current = current.next;

		}

		return size == visited.size();

	}



	void add(int x) {

// precondition: repOk()

// postcondition: repOk() && x is added at head

		Node n = new Node();

		n.elem = x;

		n.next = header;

		header = n;

		size++;

	}



	void remove(int x) { /*...*/ }



	@Test public void abst() {

		// create receiver object state

		LinkedList l = new LinkedList();

		l.add(0);



		l.add(1); // execute method to test



		assertTrue(l.repOk()); // check output

	}



	@Test public void conc() {

		// create receiver object state

		LinkedList l = new LinkedList();

		Node n0 = new Node();

		l.header = n0; l.size = 1;

		n0.elem = 0; n0.next = null;



		l.add(1); // execute method to test



		assertTrue(l.repOk()); // check output

	}

}