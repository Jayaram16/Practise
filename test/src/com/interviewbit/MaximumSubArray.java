package com.interviewbit;

import java.util.Arrays;
import java.util.Random;

/**
 * This is an important question asked by various interviewers. Concept is
 * simple. keep track of local minima and compare it to global maxima when sum
 * value is greater than previous sum values.
 * 
 * @author Jayaram
 *
 */
// TODO :The max product of consecutive elements in an array
public class MaximumSubArray {

	public static void main(String[] args) {
		int array[] = new int[10];
		generateRandom(array);
		System.out.println(Arrays.toString(array));

		MaximumSubArray maxObj = new MaximumSubArray();
		System.out.println("Max Value is " + maxObj.maxSubArray(array));
		System.out.println("Max Value is " + maxObj.maxSubArrayUsingShorterCode(array));
		System.out.println("Max Value is " + maxObj.maxSumArrayNSquare(array));
	}

	// [-2, 1, 4, -4, 4, 1, -3, 2, 4, 3]
	// using O(n)
	private int maxSubArray(int[] array) {
		int val = array[0];
		int max = array[0];
		// val would hold the sequence maximum or will hold the last value of
		// the array.
		// max holds the global maximum.

		// The indexing options have been found from the url:
		// http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
		int globalStart = 0, globalEnd = 0;

		for (int i = 1; i < array.length; i++) {
			int localStart = globalStart;
			int localEnd = globalEnd;

			if (array[i] > val + array[i]) {
				val = array[i];
				localStart = i;
				localEnd = i;
			} else {
				val = val + array[i];
				localEnd = i;
			}
			if (max < val) {
				max = val;
				globalStart = localStart;
				globalEnd = localEnd;
			}

		}
		System.out.println("The start is " + globalStart);
		System.out.println("The end is " + globalEnd);
		// System.out.println("Start is " + start+1);
		return max;
	}

	private int maxSubArrayUsingShorterCode(int[] array) {
		int val = array[0];
		int max = array[0];
		// val would hold the sequence maximum or will hold the last value of
		// the array.
		// max holds the global maximum.
		// int start = 0;
		

		for (int i = 1; i < array.length; i++) {
			val = Math.max(val + array[i], array[i]);
			max = Math.max(val, max);
		}
		return max;
	}

	/**
	 * 
	 * 
	 * The inner loop will add the the values from i to n Outer loop will slowly
	 * decrease the i value till n. Inside the inner for loop, the array value
	 * is added. Remember to reset the value to 0 .
	 * 
	 * @param array
	 * @return
	 */
	// Using O(n^2)
	private int maxSumArrayNSquare(int[] array) {
		int max = 0;
		int val = 0;
		for (int i = 0; i < array.length; i++) {
			val = 0;
			for (int j = i; j < array.length; j++) {
				val += array[j];
				if (max < val) {
					max = val;
				}

			}
		}
		return max;
	}

	private static void generateRandom(int[] array) {
		Random ran = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = (ran.nextInt(10) - 5);
		}
	}

}
