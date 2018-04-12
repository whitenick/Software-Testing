package pset4;

/**
 * Created by Kaiyuan_Wang on 4/6/16.
 */
public class Pair<X, Y> {
    private X x;
    private Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X first() {
        return x;
    }

    public Y second() {
        return y;
    }
}
