package com.interviewbit;

import java.util.Arrays;
import java.util.Random;

//TODO :The max product of consecutive elements in an array
public class MaximumSubArray {

	public static void main(String[] args) {
		int array[] = new int[10];
		generateRandom(array);
		System.out.println(Arrays.toString(array));

		MaximumSubArray maxObj = new MaximumSubArray();
		System.out.println("Max Value is " + maxObj.maxSubArray(array));
		System.out.println("Max Value is " +maxObj.maxSubArrayUsingShorterCode(array));
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

		//The indexing options have been found from the url: http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
		int begin = 0, end = 0;

		for (int i = 1; i < array.length; i++) {
			int newBegin = begin;
			int newEnd = end;

			if (array[i] > val + array[i]) {
				val = array[i];
				newBegin = i;
				newEnd = i;
			} else {
				val = val + array[i];
				newEnd = i;
			}
			if (max < val) {
				max = val;
				begin = newBegin;
				end = newEnd;
			}

		}
		System.out.println("The start is " + begin);
		System.out.println("The end is " + end);
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
		int begin = 0, end = 0;

		for (int i = 1; i < array.length; i++) {
			val = Math.max(val + array[i], array[i]);
			max = Math.max(val, max);
		}
		return max;
	}

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
