package test.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = new int[10];

		new HeapSort().sort(a);

	}

	private void sort(int[] a) {
		generateRandomArray(a);
		// System.out.println(Arrays.toString(a).toString());
		System.out.println("Before");
		System.out.println(Arrays.toString(a));
		long before = System.currentTimeMillis();
		heapSort(a);
		long after = System.currentTimeMillis();
		System.out.println("After");
		System.out.println(Arrays.toString(a));
		System.out.println("Time taken in InsertionSort in milliseconds " + (after - before));

		// System.out.println(Arrays.toString(a).toString());
	}

	private void heapSort(int[] a) {
		int total = a.length - 1;
		for (int level = a.length / 2; level >= 0; level--) {
			heapify(a, level, total);
		}
		for(int i=total;i>=0;i--){
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			heapify(a,0,i-1);
		}

	}

	/*
	 * This method is used to percolate down the values to arrange in the
	 * heapsort
	 */
	private void heapify(int a[], int level, int total) {
		int left = 2 * level + 1;
		int right = 2 * level + 2;
		int pointer = level;
		if (left <= total && a[left] > a[pointer]) {
			pointer = left;
		}
		if (right <= total && a[right] > a[pointer]) {
			pointer = right;
		}
		if (pointer != level) {
			int temp = a[pointer];
			a[pointer] = a[level];
			a[level] = temp;
			// the recursive call is important to ensure if the swapped value
			// i.e in the new position is less than its child nodes, then
			// swapping of those nodes must take place
			heapify(a, pointer, total);
		}
	}

	public void generateRandomArray(int a[]) {
		int arraySize = a.length;
		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			a[i] = (int) (Math.random() * 50) + 10;

		}
	}
}
