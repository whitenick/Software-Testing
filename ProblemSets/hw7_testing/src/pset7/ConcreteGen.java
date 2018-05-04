package pset7;


import gov.nasa.jpf.vm.Verify;



public class ConcreteGen {

    public static void main(String[] a) {

        Verify.resetCounter(0); // count invalid

        Verify.resetCounter(0); // count valid



// allocate objects

        LinkedList l = new LinkedList();

        LinkedList.Node n0 = new LinkedList.Node();

        LinkedList.Node n1 = new LinkedList.Node();



//initialize field domains

        LinkedList.Node[] nodes = new LinkedList.Node[]{ null, n0, n1 };

        int[] elems = new int[]{ 0, 1 };



// set fields

        l.header = nodes[Verify.getInt(0, nodes.length - 1)];

        l.size = Verify.getInt(0, 2);

        n0.next = nodes[Verify.getInt(0, nodes.length - 1)];

        n0.elem = elems[Verify.getInt(0, elems.length - 1)];

        n1.next = nodes[Verify.getInt(0, nodes.length - 1)];

        n1.elem = elems[Verify.getInt(0, elems.length - 1)];



// check if structure is valid using repOk as a filter

        if (l.repOk()) {

            Verify.incrementCounter(1);

            System.out.println("Valid: " + Verify.getCounter(1));

        } else {

            Verify.incrementCounter(0);

            System.out.println("Invalid: " + Verify.getCounter(0));

        }

    }

}