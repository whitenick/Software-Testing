package pset7;

import static org.junit.Assert.*;
import org.junit.Test;

public class RegressionTest {
	@Test
	public void tae0() {
		RegressionMin minTest = new RegressionMin();
		assertEquals(1, minTest.min(1,2,3));
	}

	@Test
	public void yismin() {
		assertEquals(1, RegressionMin.min(2,1,3));
	}

	@Test 
	public void zismin() {
		assertEquals(1, RegressionMin.min(2,3,1));
	}
}
