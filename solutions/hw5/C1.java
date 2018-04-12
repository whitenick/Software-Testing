package pset4;

/**
 * Created by Kaiyuan_Wang on 4/6/16.
 */
public class C1 {
    int max(int x, int y) {
        if (x < y) {
            return y;
        } else return x;
    }

    int avg(int x, int y) {
        return (x + y) / 2;
    }

    int mess(int... ints) {
        if (ints[0] < 2 && ints[1] > 5) {
            if (ints[2] == ints[3] || ints[2] == ints[4] && ints[2] < 0)
                return 1;
            else if (ints[3] % 2 == 0)
                return 2;
            else {
                return 3;
            }
        }
        return 0;
    }
}
