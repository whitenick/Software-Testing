package pset4;

/**
 * Created by Kaiyuan_Wang on 4/6/16.
 */
public class D1 {
    public static void main(String[] a) {
        foo(a);
        bar(a);
    }

    static void foo(String[] a) {
        if (a == null) return;
        bar(a);
    }

    static void bar(String[] a) {}
}
