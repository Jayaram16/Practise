/**
 * 
 */
package com.java.practise;

import java.util.Arrays;

/**
 * 
 * Given a number n, find the smallest number that has same set of digits as n
 * and is greater than n. If x is the greatest possible number with its set of
 * digits, then print “Cannot find greater number”.
 *
 * 
 * @author Jayaram
 *
 */
public class FindNextLargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int n = 781854;
		int n = 124;
		int num[] = intToIntArray(n);

		getNextGreatestNumber(num);

		int afterN = intArrayToInt(num);
		System.out.println("BiggerNumber is " + afterN);
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	private static int intArrayToInt(int[] num) {
		int number = 0;
		for (int i = 0; i < num.length; i++) {
			number += num[i];
			number *= 10;
		}
		number /= 10;
		return number;
	}

	private static int[] intToIntArray(int n) {
		String str = String.valueOf(n);
		int a[] = new int[str.length()];
		int counter = 0;
		for (char c : str.toCharArray()) {
			a[counter++] = c - '0';
		}
		return a;
	}

	/**
	 * Utility method which finds the next biggest number. 1) Start from extreme
	 * right.Go left till there is a number less than the right number.
	 * 2)Now from that point till the end of right, find the just largest of the turn.
	 * 3) Swap that just number with the turning number.
	 * 4) Sort the number to the right of the just numbers in ascending order.
	 * 
	 * @param num
	 */
	public static void getNextGreatestNumber(int[] num) {
		int n = num.length;
		int i = n - 1;
		for (; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				break;
			}
			// else continue
		}
		// all numbers are in descending orders and hence cannot find the next
		// bigger number
		if (i == 0) {
			System.out.println("Cannot find greater number");
			return;// null;
		}
		// in ascending order
		if (i == n - 1) {
			int temp = num[i];
			num[i] = num[i - 1];
			num[i - 1] = temp;
			return;// num;
		}
		// else do the dance...
		// Find the next biggest number than the current i-1 so as to swap them
		int x = num[i - 1], nextBiggerIndex = i;
		for (int j = i + 1; j < n; j++) {
			if (num[j] > x && num[nextBiggerIndex] > num[j]) {
				nextBiggerIndex = j;
			}
		}
		// swap i-1 and nextBiggerIndex;
		int temp = num[i - 1];
		num[i - 1] = num[nextBiggerIndex];
		num[nextBiggerIndex] = temp;

		// Now sort from i to end.
		Arrays.sort(num, i, n);

		return;// num;
	}

}
