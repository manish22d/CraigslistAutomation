package com.craigslist.TestCases;

import org.testng.annotations.Test;

public class StringTest {

	@Test
	public void testMethod() {
		String a = "121";
		char[] b = a.toCharArray();
		char[] x = "".toCharArray();
		int j = 0;
		for (int i = b.length - 1; i > 0; i--) {
			System.out.println(b[i]);
			x[j] = b[i];
			j = j + 1;
		}

		if (x.toString() == b.toString()) {
			System.out.println("this is equal");
		}
	}

}
