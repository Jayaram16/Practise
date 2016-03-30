package com.test.amazon.questions;

import java.util.Arrays;

import test.sort.HeapSort;

/**
 * Connect n ropes with minimum cost in Java
 * 
 * Following is complete algorithm for finding the minimum cost for connecting n
 * ropes. Let there be n ropes of lengths stored in an array len[0..n-1] 1)
 * Create a min heap and insert all lengths into the min heap. 2) Do following
 * while number of elements in min heap is not one. ……a) Extract the minimum and
 * second minimum from min heap ……b) Add the above two extracted values and
 * insert the added value to the min-heap. 3) Return the value of only left item
 * in min heap.
 * 
 * 
 * @author Jayaram http://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */
public class ConnectNRopesWithMinimalCost {

	public static void main(String[] args) {
		int[] a = new int[3];
		HeapSort obj = new HeapSort();
		obj.generateRandomArray(a);
		System.out.println(Arrays.toString(a));
		ConnectNRopesWithMinimalCost selfObj = new ConnectNRopesWithMinimalCost();
		int minimalCost = selfObj.getMinimalCost(a);
		System.out.println("The minimal cost is " + minimalCost);
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	private int getMinimalCost(int[] a) {
		// Initial heap
		createMinHeap(a, a.length - 1);
		int numberOfElementRemaining = a.length;
		while (numberOfElementRemaining != 1) {
			// Find first minimal number
			int minimalElement = a[0];
			swap(a[0], a[numberOfElementRemaining - 1]);
			int temp = a[0];
			a[0] = a[numberOfElementRemaining - 1];
			a[numberOfElementRemaining - 1] = temp;
			minHeapify(a, 0, numberOfElementRemaining - 2);
			// Find second minimal number
			int secondMinimalElement = a[0];
			int newElement = minimalElement + secondMinimalElement;
			// Place the added value to the head and heapify again.
			a[0] = newElement;
			minHeapify(a, 0, numberOfElementRemaining - 2);
			numberOfElementRemaining--;

		}
		return a[0];
	}

	void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	void createMinHeap(int[] a, int total) {
		// This creates the initial heap;
		for (int i = total / 2; i >= 0; i--) {
			minHeapify(a, i, total);
		}
	}

	void minHeapify(int a[], int level, int total) {
		int left = 2 * level + 1;
		int right = 2 * level + 2;
		int pointer = level;
		if (left <= total && a[left] < a[pointer]) {
			pointer = left;
		}
		if (right <= total && a[right] < a[pointer]) {
			pointer = right;
		}
		if (level != pointer) {
			int temp = a[level];
			a[level] = a[pointer];
			a[pointer] = temp;
			minHeapify(a, pointer, total);
		}
	}

}
