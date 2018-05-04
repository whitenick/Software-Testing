package pset7;



import gov.nasa.jpf.vm.Verify;



public class AbstractGen {

    public static void main(String[] a) {

        Verify.resetCounter(0); // sequence counter

        StringBuffer seq = new StringBuffer();

        final int SEQ_LENGTH = Verify.getInt(0, 2);

        seq.append("LinkedList l = new LinkedList();");

        LinkedList l = new LinkedList();

        assert l.repOk();

        for (int i = 0; i < SEQ_LENGTH; i++) {

            if (Verify.getBoolean()) {

                int x = Verify.getInt(0, 1);

                seq.append(" l.remove(" + x + ");");

                l.remove(x);

                assert l.repOk();

            } else {

                int x = Verify.getInt(0, 1);

                seq.append(" l.add(" + x + ");");

                l.add(x);

                assert l.repOk();

            }

        }

        Verify.incrementCounter(0);

        System.out.println(Verify.getCounter(0) + ": " + seq);

    }

}
