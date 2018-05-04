package pset7;

import java.util.*;

public class RegressionMin {

	public RegressionMin() {

	}

	public static int min(int x, int y, int z) {
		if(x < y) {
			if(x < z) {
				return x;
			} else {
				return y; // here is the bug. Change to return z instead. Only test to rerun in regression is the test that covers this line
			}
		}

		if(y < z) {
			return y;
		}

		return z;
	}

	// direct verification of outputs 

	static boolean checkSort(int[] arr) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		sort(arr);
		for(int x: arr) {
			if(count(x, arr) != count(x, copy)) {
				return false;
			}
		}
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}

		return true;
	}

	static void sort(int[] arr) {
	}

	static int count(int x, int[] arr) {
		return 0;
	}
}
