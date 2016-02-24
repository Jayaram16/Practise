package test.sort;

import java.util.Arrays;

//Using middle value as pivot
public class QuickSortAgain {
	int[] theArray = new int[10];

	public static void main(String[] args) {
		QuickSortAgain quickSortAgain = new QuickSortAgain();
		quickSortAgain.generateRandomArray();
		System.out.println(Arrays.toString(quickSortAgain.theArray).toString());

		partition(quickSortAgain.theArray, 0, quickSortAgain.theArray.length - 1);
		System.out.println("After sorting " + Arrays.toString(quickSortAgain.theArray).toString());

	}

	private static void partition(int[] a, int first, int last) {
		int i = first, j = last, pivot = a[first + (last - first) / 2];

		while (i < j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (i < last) {
			partition(a, i, last);
		}
		if (j > first) {
			partition(a, first, j);
		}

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
