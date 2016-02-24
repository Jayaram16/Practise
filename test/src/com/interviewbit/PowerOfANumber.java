package com.interviewbit;

public class PowerOfANumber {
	/**
	 * This is using recursive stack
	 */
	public int power(int num, int pow) {
		if (pow == 0) {
			return 1;
		}
		if (pow == 1) {
			return num;
		}
		if (pow % 2 == 1) {
			return num * power(num, pow - 1);
		} else {
			int val = power(num, pow / 2);
			return val * val;
		}
	}

	public static void main(String a[]) {
		System.out.println(new PowerOfANumber().power(4, 8));
		System.out.println(new PowerOfANumber().powerUsingLinearApproach(4, 8));
	}

	/**
	 * Using Linear. This is a very tricky one. So the limiting condition, we
	 * have set to >0 .and we are returning 'result'. In i%2==0 we are multiplying the same number but not returning
	 */
	public int powerUsingLinearApproach(int num, int pow) {
		int i = pow;
		if (i == 0) {
			return 1;
		}
		int result = 1;
		while (i > 0) {
			if (i % 2 == 1) {
				i--;
				result *= num;
			}
			if (i % 2 == 0) {
				// int val = num * num;
				num *= num;
				i /= 2;
			}
		}
		return result;
	}
}
