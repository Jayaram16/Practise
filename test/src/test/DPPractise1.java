package test;

import java.util.Scanner;

public class DPPractise1 {

	public static void main(String[] args) {

		Scanner src=new Scanner (System.in);
		System.out.println("Enter the length ");
		int n=src.nextInt();
		int a[] = new int[n];
		for(int i =0;i<n;i++){
			a[i]=src.nextInt();
		}
		System.out.println(a.length);
		new DPPractise1().calculateMax(a,n);
	}

	private int calculateMax(int[] a,int n) {
		
			
		return Math.max(calculateMax(a,n-1),n+calculateMax(a,n-2));
		
	}

}
