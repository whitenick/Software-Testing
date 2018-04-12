package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class E4 {
    static void m1() {
        m2();
    }

    static void m2() {
        m3();
    }

    static void m3() {
        m1();
    }
}
