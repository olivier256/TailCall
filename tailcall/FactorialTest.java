package tailcall;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void test() {
		assertEquals(Long.valueOf(6), new Factorial(3).call());
		assertEquals(Long.valueOf(720), new Factorial(6).call());
	}

}
