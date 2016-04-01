/**
 * 
 */
package com.java.practise;

/**
 * 
 * Replace m zeros with 1s to find maximum length 1s
 *
 * 2 questions are answered here.
 * One where there could be more than 1 zero to be replaced.
 * Other where only 1 zero is to be replaced.
 * 
 * @author Jayaram
 *
 */
public class MaxArray1sReplaceM0s {

	/**
	 * 
	 * Use concept of sliding window
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		int arr[] = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1 };
		int m = 2;
		// When there could be more than 1 Zeros
		findZerosUsingSlidingWindow(arr, m);
		// When only 1 zero needs to be replaced
		maxOnesIndex(arr, arr.length);

	}

	/**
	 * Use the concept of Sliding Window Concept Adv: the number of m can be
	 * varied. Drawback: The entire array is traversed slightly more than n;
	 * 
	 * @param arr
	 * @param m
	 */
	private static void findZerosUsingSlidingWindow(int[] arr, int m) {

		int leftWindow = 0;
		int rightWindow = 0;
		int maxWindow = 0;
		int maxLeft = 0;
		int countOfZeros = 0;

		int n = arr.length;
		while (rightWindow < n) {

			// If zero count of current window is less than m,
			// widen the window toward right
			if (countOfZeros <= m) {
				if (arr[rightWindow] == 0)
					countOfZeros++;
				rightWindow++;

			}
			// If zero count of current window is more than m,
			// reduce the window from left
			// This will take some time as we need to come to the next 0
			if (countOfZeros > m) {
				if (arr[leftWindow] == 0) {
					countOfZeros--;
				}
				leftWindow++;
			}
			// Check and update the max windowSize
			if (rightWindow - leftWindow > maxWindow) {
				maxWindow = rightWindow - leftWindow;
				maxLeft = leftWindow;
			}
		}

		// Print positions of zeroes in the widest window
		for (int i = 0; i < maxWindow; i++) {
			if (arr[i + maxLeft] == 0) {
				System.out.print(" " + (i + leftWindow));
			}
		}

	}

	/**
	 * Returns index of 0 to be replaced with 1 to get longest continuous
	 * sequence of 1s. If there is no 0 in array, then it returns -1.
	 * 
	 * @param arr
	 * @param n
	 *
	 */
	static int maxOnesIndex(int arr[], int n) {
		int maxCount = 0; // for maximum number of 1 around a zero
		int maxIndex = 0; // for storing result
		int prevZero = -1; // index of previous zero
		int prevPrevZero = -1; // index of previous to previous zero

		// Traverse the input array
		for (int curr = 0; curr < n; ++curr) {
			// If current element is 0, then calculate the difference
			// between curr and prev_prev_zero
			if (arr[curr] == 0) {
				// Update result if count of 1s around prev_zero is more
				if (curr - prevPrevZero > maxCount) {
					maxCount = curr - prevPrevZero;
					maxIndex = prevZero;
				}

				// Update for next iteration
				prevPrevZero = prevZero;
				prevZero = curr;
			}
		}

		// Check for the last encountered zero
		if (n - prevPrevZero > maxCount)
			maxIndex = prevZero;

		System.out.println("Index where 0 is found for only 1 instance is " + maxIndex);
		return maxIndex;
	}
}
