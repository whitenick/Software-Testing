package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class D4 {
    static int a() {
        a(1);
        return 1;
    }

    static String a(int i) {
        a();
        a(1.0, 2, false);
        return i + "";
    }

    static void a(String[] ss) {
        a(new String[]{});
        ss[0] = "";
    }

    static int a(double d, int i, boolean b) {
        if (b) {
            a(2);
            return i;
        } else {
            a();
            return (int) d + i;
        }
    }

    public static void main(String... args) {
        a();
        a(1,2,false);
    }
}
