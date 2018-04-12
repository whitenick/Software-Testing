package pset4;

/**
 * Created by Kaiyuan_Wang on 4/20/16.
 */
public class E5 {
    public static int m1() {
        int i = 0;
        m2(i);
        i = 1;
        m3(i);
        i = 2;
        return i;
    }

    public static void m2(int i) {}

    public static void m3(int i) {}
}
