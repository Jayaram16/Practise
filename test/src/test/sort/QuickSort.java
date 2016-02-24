package test.sort;

import java.util.Arrays;

//Using Last as pivot
public class QuickSort {
	int[] theArray = new int[10000];

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.generateRandomArray();
		System.out.println(Arrays.toString(qs.theArray).toString());
		long before= System.currentTimeMillis();
		qs.quickSort(0, qs.theArray.length - 1);
		long after= System.currentTimeMillis();
		System.out.println(Arrays.toString(qs.theArray).toString());
		System.out.println("Time taken in QuickSort in milliseconds "+(after-before));
	}

	private void quickSort(int first, int last) {
		if (first <last) {
			int pivot = theArray[last];
			int p = partition(first, last, pivot);
			quickSort(first, p - 1);
			quickSort(p + 1, last);
		}

	}

	private int partition(int left, int right, int pivot) {

		int i = left - 1;
		int j = right;
		while (true) {
			while (theArray[++i] < pivot)
				;
			while (j > 0 && theArray[--j] > pivot)
				;

			if (i >= j) {
				break;
			} else {
				swap(i, j);
			}
		}
		swap(right, i);
		return i;
	}

	private void swap(int i, int j) {
		int val = theArray[i];
		theArray[i] = theArray[j];
		theArray[j] = val;
	}

	public void generateRandomArray() {
		int arraySize = theArray.length;
		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}
	}

}
