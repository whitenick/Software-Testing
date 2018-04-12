package pset4;

public class E1 {
	public static void foo() {
		bar();
	}

	public static void bar(){
		foo();
	}

	public static void x() {
		x();
	}
}