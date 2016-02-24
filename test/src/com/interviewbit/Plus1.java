package com.interviewbit;

import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits,
 * 
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 * 
 * NOTE: Certain things are intentionally left unclear in this question which
 * you should practice asking the interviewer. For example, for this problem,
 * following are some good questions to ask : Q : Can the input have 0’s before
 * the most significant digit. Or in other words, is 0 1 2 3 a valid input? A :
 * For the purpose of this question, YES Q : Can the output have 0’s before the
 * most significant digit? Or in other words, is 0 1 2 4 a valid output? A : For
 * the purpose of this question, NO. Even if the input has zeroes before the
 * most significant digit.
 */

public class Plus1 {
	public static void main(String arp[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		a.add(9);
		// System.out.println(new Plus1().plusOne(a));
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(0);
		System.out.println(new Plus1().plusOneTwo(a));
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		if (a == null) {
			return null;
		}
		int i = 0;
		int size = a.size();
		long val = 0;
		while (i < size) {
			val *= 10;
			val += a.get(i);
			i++;
		}
		val++;
		System.out.println("val is " + val);
		long div = 10;
		i = 1;
		while (i < size) {
			div *= 10;
			i++;
		}
		System.out.println("div " + div);
		int divVal = 0;
		do {
			divVal = (int) (val / div);
			div /= 10;
		} while (divVal == val);
		System.out.println("div " + div);
		System.out.println(divVal);
		ArrayList<Integer> output = new ArrayList<Integer>();
		// output.add(divVal);
		// val = val % div;
		while (val != 0) {
			divVal = (int) (val / div);
			output.add(divVal);
			val = val % div;
			div /= 10;

		}
		return output;
	}

	public ArrayList<Integer> plusOneTwo(ArrayList<Integer> a) {
		if (a == null) {
			return null;
		}

		int i = a.size() - 1;
		boolean flag = true;
		int carry = 0;
		while (i >= 0 && flag) {
			if (a.get(i) == 9) {
				a.set(i, 0);
				carry = 1;
			} else {
				int val = a.get(i);
				a.set(i, ++val);/// Most important here . This should be pre
								/// increement
				// if(a.get(i)!=0){
				flag = false;
				carry = 0;
				// }
			}
			i--;
		}
		int j = 0;
		if (carry == 0) {
			while (a.get(j) == 0) {/// This is very important as it removes
									/// zeros at the beginning.
				a.remove(j);// No need to increement j as remove will remove
							// first values
			}
			return a;
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		output.add(carry);
		for (i = 0; i < a.size(); i++) {
			output.add(a.get(i));
		}
		return output;
	}

	public ArrayList<Integer> plusOneBySolutionProvider(ArrayList<Integer> A) {

		int size;
		int carry = 1;
		int num;

		size = A.size();

		for (int i = size - 1; i >= 0; i--) {

			num = A.get(i);
			num += carry;
			carry = 0;

			if (num == 10) {
				num = 0;
				carry = 1;
			}

			A.set(i, num);

		}

		ArrayList<Integer> res = new ArrayList<Integer>();

		if (carry == 1)
			res.add(1);

		for (int x : A) {
			if (x == 0 && res.size() == 0)
				continue;
			res.add(x);
		}

		return res;

	}
}
