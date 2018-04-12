package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class D3 {
    static void a() {
        b();
        d();
        c();
        a();
    }

    static int b() {
        b();
        a();
        c();
        return (int) d();
    }

    static boolean c() {
        b();
        c();
        a();
        d();
        return c();
    }

    static double d() {
        a();
        c();
        d();
        b();
        return b() * 1.0;
    }
}
