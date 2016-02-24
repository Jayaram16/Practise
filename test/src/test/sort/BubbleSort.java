package test.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int a[] = new int[10];
		generateRandom(a);
		System.out.println("Before");
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println("After");
		System.out.println(Arrays.toString(a));
	}

	private static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	private static void generateRandom(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}

	}

}
