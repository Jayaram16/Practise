package com.interviewbit;

public class GCD {
	public static void main(String as[]) {

		GCD gcdObj = new GCD();
		System.out.println(gcdObj.gcdUsingLongApproach(4, 6));
		System.out.println("Using shorter approach " + gcdObj.gcd(4, 6));
	}

	/**
	 * a should always be less than b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int gcd(int a, int b) {
		if (a == 0) {
			return b;
		} else {
			return gcd(b % a, a);
		}

	}

	/**
	 * Long approach
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcdUsingLongApproach(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		if (a == 1 || b == 1) {
			return 1;
		}
		// a should be smaller value
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = a; i >= 1; i--) {
			if (b % i == 0 && a % i == 0) {
				return i;
			}
		}
		return 1;
	}
}
