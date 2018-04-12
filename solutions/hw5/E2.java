package pset4;

public class E2 {
	public static void m1(int x, int y) {
		if (x < y)
            m2();
        else if (x == y)
            m3();
	}

	public static void m2() {
        m1(1,2);
    }

    public static int m3() {
        return 0;
    }
}