package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class E3 {
    static void m1() {
        for (int i = 0; i < 20; i++) {
            m2();
            return;
        }
    }

    static void m2() {
        for (int i = 0; i < 20; i++) {
            m1();
            return;
        }
    }

    static void m3() {
        for (int i = 0; i < 20; i++) {
            m3();
            return;
        }
    }
}
