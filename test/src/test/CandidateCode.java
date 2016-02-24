package test;

public class CandidateCode {
	public static int CompanyRecruitment(int[] input1, int input2) {
		if (input2 == input1.length) {
			return 1;
		}
		if (input2 <= 0 || input2 > input1.length) {
			return 0;
		}
		int[] sortedArray = sort(input1);
		int[] arrayFromFunction = findKSumMaximum(sortedArray, input2);
		int sumValue = arrayFromFunction[0];
		int loopCounter = input2;
		int counter = 0;
		int repeatedValue = sortedArray[loopCounter - 1];
		while (loopCounter < sortedArray.length && sortedArray[loopCounter] == repeatedValue) {
			++counter;
			++loopCounter;
		}
		return countWays(arrayFromFunction[1] + counter, counter);
		// return counter;
	}

	public static int countWays(int n, int c) {
		int ways = factorial(n) / (factorial(c) * factorial(n - c));
		return ways;
	}

	private static int factorial(int n) {
		int total = 1;
		while (n >= 1) {
			total *= n;
			--n;
		}
		return total;
	}

	public static int[] findKSumMaximum(int sortedArray[], int K) {
		int sumValue = 0;
		int index = sortedArray[0];
		int counter = 0;
		for (int i = 0; i < K; i++) {
			if (i >= 1 && index == sortedArray[i]) {
				counter++;
			} else {
				counter = 1;
				index = sortedArray[i];
			}
			sumValue += sortedArray[i];
		}
		System.out.println("The sum for K= " + K + " is " + sumValue);
		// return sumValue;
		int[] arrayFromFunction = new int[2];
		arrayFromFunction[0] = sumValue;
		arrayFromFunction[1] = counter;
		return arrayFromFunction;
	}

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}