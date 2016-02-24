package test;

import java.math.BigInteger;

public class TechGig {

	public static void main(String[] args) {
		int[] input = { 2,2 };
		System.out.println("The gcd is "+getGCD(input[0], input[1]));
		int []output=coins_value(input);
		System.out.println(output[0]+" "+output[1]);
	}

	public static int[] coins_value(int[] input1) {
		if (input1 == null || input1.length > 2 || input1.length <= 0 || !inRange(input1[0]) || !inRange(input1[1])) {
			int[] output = { 0, 0 };
			return output;
		}
		int firstNumber = input1[0];
		int secondNumber = input1[1];

		int gcdValue = getGCD(firstNumber, secondNumber);
		int output[] = getNumbers(firstNumber, secondNumber, gcdValue);

		// int output[]=new int[2];
		// output[0]=2;
		// output[1]=-1;
		return output;
	}

	public static boolean inRange(int number) {
		if (number <= 1000 && number >= 0) {
			return true;
		} else
			return false;
	}

	public static int getGCD(int first, int second) {
		return (BigInteger.valueOf(first).gcd(BigInteger.valueOf(second))).intValue();
	}

	public static int[] getNumbers(int firstNumber, int secondNumber, int gcdValue) {
		int counter = 0;
		int output[] = new int[2];
		boolean gcdMatch = false;
		while (!gcdMatch) {
			if ((gcdValue - (counter * firstNumber)) % secondNumber == 0) {
				output[0] = counter;
				output[1] = (gcdValue - (counter * firstNumber)) / secondNumber;
				gcdMatch = true;
				break;
			} else if ((gcdValue + (counter * firstNumber)) % secondNumber == 0) {
				output[0] = -counter;
				output[1] = (gcdValue + (counter * firstNumber)) / secondNumber;
				gcdMatch = true;
				break;
			} else if (((counter * firstNumber) - gcdValue) % secondNumber == 0) {
				output[0] = counter;
				output[1] = -(((counter * firstNumber) - gcdValue)/ secondNumber);
				gcdMatch = true;
				break;
			} else {
				counter++;
			}

		}
		return output;
	}
}
