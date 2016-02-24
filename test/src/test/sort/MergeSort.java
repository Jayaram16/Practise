package test.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = new int[10];
		generateRandomArray(a);
		System.out.println("Before Sorting");
		System.out.println(Arrays.toString(a));
		long before= System.currentTimeMillis();
		mergeSort(a, 0, a.length - 1);
		long after= System.currentTimeMillis();
		System.out.println("After Sorting");
		System.out.println(Arrays.toString(a));
		System.out.println("Time taken in MergeSort in milliseconds "+(after-before));

	}

	public static void generateRandomArray(int[] a) {
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			a[i] = ran.nextInt(100);
		}
	}

	private static void mergeSort(int[] a, int first, int last) {
		if (first < last) {
			int m = (first + last) / 2;
			mergeSort(a, first, m);
			mergeSort(a, m + 1, last);
			merge(a, first, m, last);
		}

	}

	private static void merge(int[] a, int first, int middle, int last) {
		int size1 = middle - first + 1;
		int size2 = last - middle;
		int[] n1 = new int[middle - first + 1];
		int[] n2 = new int[last - middle];
		// n1[middle - first] = 65537;
		// n2[last - middle] = 65537;

		for (int i = 0; i < size1; i++) {
			n1[i] = a[first + i];
		}
		for (int j = 0; j < size2; j++) {
			n2[j] = a[middle + j + 1];
		}
		/*
		 * for(int k:n1) System.out.print(k + " "); System.out.println();
		 * for(int k:n2) System.out.print(k+" ");
		 */ int i = 0;
		int j = 0;
		int k = first;
		while (i < size1 && j < size2) {
			if (n1[i] <= n2[j]) {
				a[k] = n1[i];
				i++;
			} else {
				a[k] = n2[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			a[k] = n1[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there are any */
		while (j < size2) {
			a[k] = n2[j];
			j++;
			k++;
		}
	}

}
