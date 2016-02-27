/**
 * 
 */
package com.java.practise;

import java.util.Arrays;

/**
 * Program for array rotation
 * 
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
 * elements.
 * 
 * @author Jayaram
 *
 */
public class RotateElementsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ar[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 2;
		int arf[] = rotateElementsInArray(ar, k);
		System.out.println(Arrays.equals(arf, ar));
		System.out.println(Arrays.toString(ar));

	}

	/**
	 * GCD part is very important as it indicates for all values.
	 * 
	 * @param ar
	 * @param k
	 * @return
	 */
	public static int[] rotateElementsInArray(int[] ar, int k) {
		int n = ar.length;
		int i = 0;
		int gcdNumber = gcd(n, k);

		for (int j = 0; j < gcdNumber; j++) {
			i = j;
			int val = ar[i];
			while (true) {
				int temp = ar[(i + k) % n];
				i = (i + k) % n;
				ar[i] = val;
				if (i == j) {
					break;
				}

				val = temp;
			}

		}
		return ar;
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}

}
