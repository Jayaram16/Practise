package test.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int a[] = new int[10000];
		generateRandom(a);
		System.out.println("Before Sorting ");
		System.out.println(Arrays.toString(a));
		long before= System.currentTimeMillis();
		selectionSort(a);
		long after= System.currentTimeMillis();
		System.out.println("After Sorting ");
		System.out.println(Arrays.toString(a));
		System.out.println("Time taken in milliseconds "+(after-before));
	}

	private static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int pointer = i;
			int j = i + 1;
			while (j < a.length) {
				if (a[j] < min) {
					min=a[j];
					pointer=j;
				}
				j++;
			}
			a[pointer]=a[i];
			a[i]=min;
		}
	}

	private static void generateRandom(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
	}

}
