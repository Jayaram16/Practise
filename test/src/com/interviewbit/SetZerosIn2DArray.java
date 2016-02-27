package com.interviewbit;

import java.util.ArrayList;

//Worked on interviewBit. Need to test the input again.
/**
 * Not working needs to improve on this.
 * 
 * @author Jayaram
 *
 */
public class SetZerosIn2DArray {

	public static void main(String aa[]) {
		SetZerosIn2DArray obj = new SetZerosIn2DArray();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		m.add(1);
		m.add(0);
		m.add(1);
		a.add(m);
		m = new ArrayList<Integer>();
		m.add(1);
		m.add(1);
		m.add(1);
		a.add(m);
		m = new ArrayList<Integer>();
		m.add(1);
		m.add(1);
		m.add(1);
		a.add(m);
		System.out.println("before");
		display(a);
		obj.setZeroes(a);
		System.out.println("after");
		display(a);
	}

	private static void display(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> row : a) {
			for (int i = 0; i < row.size(); i++) {
				System.out.print(a.get(i));
			}
			System.out.println();
		}
	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		boolean index[] = new boolean[1000];
		for (ArrayList<Integer> row : a) {
			boolean rowHasZero = false;
			int i = 0;
			for (i = 0; i < row.size(); i++) {
				if ((Integer) row.get(i) == 0) {
					index[i] = true;
					rowHasZero = true;
				}
			}
			if (rowHasZero) {
				i--;
				while (i >= 0) {
					row.set(i, 0);
					i--;
				}
			}
		}
		for (ArrayList<Integer> row : a) {
			for (int i = 0; i < row.size(); i++) {
				if (index[i]) {
					row.set(i, 0);
				}

			}

		}

	}
}
