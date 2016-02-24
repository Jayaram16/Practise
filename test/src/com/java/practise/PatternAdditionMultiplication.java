package com.java.practise;

public class PatternAdditionMultiplication {
	/**
	 * Asked in
	 * MAQhttp://www.geeksforgeeks.org/maq-software-interview-experience-set-11-
	 * on-campus-writen-test/ Write a program to compute the following:
	 * 1+(2*3)+(4*5*6)+…. up to n times. Where n is the given input.
	 */
	public static void main(String[] args) {

		System.out.println(new PatternAdditionMultiplication().addMultiply(6));
	}

	private int addMultiply(int n) {
		int counter = 0;
		int val = 1;
		int answer = 0;
		int intermediateVal = 1;
		for (int i = 1; i <= n; i++) {
			counter++;
			intermediateVal *= i;
			if (counter == val) {
				answer += intermediateVal;
				val++;
				counter = 0;
				intermediateVal = 1;
				// continue;
			}

		}
		if (counter != 0) {
			answer += intermediateVal;

		}
		return answer;
	}

}
