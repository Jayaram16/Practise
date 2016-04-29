package test.leetCode;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 1. Each child must have at least one candy. 2. Children with a higher rating
 * get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * @author Jayaram
 *
 */
public class CandyDistribution {

	public static void main(String[] args) {
		/* int ratings[] = { 4, 2, 1 }; */
		int ratings[] = { 1, 2, 10 };
		System.out.println(new CandyDistribution().getNumberOfCandies(ratings));
	}

	public int getNumberOfCandies(int[] ratings) {
		if (ratings == null) {
			return -1;
		}
		int n = ratings.length;
		if (n == 1) {
			return 1;
		}
		int left[] = new int[n];
		left[0] = 1;
		int right[] = new int[n];
		int val = 0;
		for (int i = 1; i < n; i++) {
			if (ratings[i - 1] < ratings[i]) {
				left[i] = left[i - 1] + 1;
			} else {
				left[i] = 1;
			}
		}

		right[n - 1] = 1;
		for (int i = n - 2; i >= 0; --i) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				right[i] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			val += Math.max(left[i], right[i]);
		}
		return val;
	}
}
