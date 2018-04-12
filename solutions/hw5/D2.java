package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class D2 {
    public static int a() {
        if (b())
            return 1;
        a();
        return 0;
    }

    public static boolean b() {
        if (a() == 1)
            return false;
        else
            return true;
    }
}
