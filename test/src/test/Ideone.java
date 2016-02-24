package test;

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone {
	public static void main(String[] args) throws java.lang.Exception {
		System.out.println("Enter the size of the array");
		Scanner src = new Scanner(System.in);
		int size = src.nextInt();
		int input[] = new int[size];

		for (int i = 0; i < size; i++) {
			input[i] = src.nextInt();
		}
		for (int i = 0; i < size; i++) {
			if (input[i] == 42) {
				break;
			} else {
				System.out.println(input[i]);
			}
		}

	}
}