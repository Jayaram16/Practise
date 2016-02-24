package test;

import java.util.Arrays;

public class SumOfTwoNumbersInArray {
	/*
	 * Write a C program that, given an array A[] of n numbers and another
	 * number x, determines whether or not there exist two elements in S whose
	 * sum is exactly x
	 */
	public static void main(String[] args) {
		int a[] = { 1, 2, 41, 21, 10, 5, 14, 54, 6, 12 };
		System.out.println("Sum found "+sumOfTwoNumbersInArray(a,12));
	}

	private static boolean sumOfTwoNumbersInArray(int a[],int sum) {
		Arrays.sort(a);
		int leftCounter=0,rightCounter=a.length-1;
		while(leftCounter<=rightCounter){
			if(a[leftCounter]+a[rightCounter]==sum){
				return true;
			}
			if(a[leftCounter]+a[rightCounter]<sum){
				leftCounter++;
			}
			if(a[leftCounter]+a[rightCounter]>sum){
				rightCounter--;
			}
		}
		return false;
	}

}
