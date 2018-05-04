package pset7;

// java code from Lecture 4/04

import static org.junit.Assert.*;



import java.util.Arrays;

import java.util.LinkedList;

import java.util.List;

import java.util.Set;

import java.util.TreeSet;



import org.junit.After;

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.Test;



public class CoverageExample {

//static Set<Integer> covered = new TreeSet<Integer>();

    static final int NUM_STATEMENTS = 4;

    static final int NUM_CONDITIONAL_BRANCHES = 2;

    static boolean[] coveredStatement = new boolean[NUM_STATEMENTS];

    static boolean[] coveredCondBranch = new boolean[NUM_CONDITIONAL_BRANCHES];



    static List<Integer> path = new LinkedList<Integer>();



    static void coveredStatement(int i) {

        coveredStatement[i - 1] = true;

    }



    static void coveredCondBranch(int i) {

        coveredCondBranch[i - 1] = true;

    }



    static void covered(int i) {

        path.add(i);

    }



    static int min(int x, int y) { // path coverage

        /*1*/covered(1); int result = x;

        /*2*/covered(2); if (y < x) {

            /*3*/covered(3); result = y;

        }

        /*4*/covered(4); return result;

    }





//static int min(int x, int y) { // conditional branch coverage

//int result = x;

//if (y < x) { coveredCondBranch(1);

//result = y;

//} else {

//coveredCondBranch(2);

//}

//return result;

//}





//static int min(int x, int y) { // statement coverage

///*1*/covered(1); int result = x;

///*2*/covered(2); if (y < x) {

///*3*/covered(3); result = y;

//}

///*4*/covered(4); return result;

//}



    @Before public void before() {

        path.clear();

    }



    @Test public void t0() {

        assertEquals(0, min(0, 1));

    }



    @Test public void t1() {

        assertEquals(1, min(2, 1));

    }



    @Test public void t2() {

        assertEquals(2, min(2, 2));

    }



    @After public void after() {

        System.out.println(path);

    }



    @AfterClass public static void afterclass() {

//System.out.println(Arrays.toString(coveredStatement));

//System.out.println(Arrays.toString(coveredCondBranch));

    }



//static int min2(int x, int y) {

//int result = x; if (y < x) { result = y; } return result;

//}



//static int min(int x, int y) {

///*1*/System.out.println("@1"); int result = x;

///*2*/System.out.println("@2"); if (y < x) {

///*3*/System.out.println("@3"); result = y;

//}

///*4*/System.out.println("@4"); return result;

//}



}