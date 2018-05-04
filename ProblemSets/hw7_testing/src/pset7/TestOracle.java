package pset7;

// lecture 04/02

import static org.junit.Assert.*;



import org.junit.Test;



public class TestOracle {

    static int m(int x) { // method under test

        return x + 1;

    }



    @Test public void t0() {

        int input = 0;

        int expected = 1;

        assertEquals(expected, m(input));

    }



    @Test public void t1() {

        int input = 1;

        int expected = 2;

        assertEquals(expected, m(input));

    }



    static boolean oracle(int input, int output) { // test oracle

        return output ==  input + 1;

    }



    @Test public void t2() {

        int input = 0;

        assertTrue(oracle(input, m(input)));

    }



    @Test public void t3() {

        int input = 1;

        assertTrue(oracle(input, m(input)));

    }



    static boolean oracle_simple(int input, int output) { // weaker test oracle

        return output > input;

    }



    @Test public void t4() {

        int input = 0;

        assertTrue(oracle_simple(input, m(input)));

    }



    @Test public void t5() {

        int input = 1;

        assertTrue(oracle_simple(input, m(input)));

    }



    static int m_faulty(int x) { // method under test

        return x + 2;

    }



    @Test public void t6() {

        int input = 0;

        assertTrue(oracle(input, m_faulty(input)));

    }



    @Test public void t7() {

        int input = 0;

        assertTrue(oracle_simple(input, m_faulty(input)));

    }

}