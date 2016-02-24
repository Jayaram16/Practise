package test.sort;

import java.util.Arrays;

public class InsertionSort {
	int[] a = new int[10];

	public static void main(String[] args) {
		new InsertionSort().sort();

	}

	private void sort() {
		generateRandomArray();
		System.out.println(Arrays.toString(a).toString());
		long before = System.currentTimeMillis();
		insertionSort();
		long after = System.currentTimeMillis();
		System.out.println("Time taken in InsertionSort in milliseconds " + (after - before));

		System.out.println(Arrays.toString(a).toString());
	}

	private void insertionSort() {
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			int val = a[i];

			while (j >= 0 && a[j] > val) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = val;
		//	System.out.println("After Iteration " + i);
			//System.out.println(Arrays.toString(a));
		}
	}

	public void generateRandomArray() {
		int arraySize = a.length;
		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			a[i] = (int) (Math.random() * 50) + 10;

		}
	}
}
