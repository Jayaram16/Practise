package test.leetCode;

public class RainWaterTrapping {
	/**
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * 
	 * I have found that it is not necessarily true that integers must be non
	 * negative. It works for all integers and mix of them as well.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int height[]={ 0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new RainWaterTrapping().gatherRainWater(height));
	}

	/**
	 * 
	 * @param height
	 * @return -1 if not a valid scenario
	 */
	public int gatherRainWater(int[] height) {
		int result = 0;
		int n = height.length;
		if (height == null || n <= 2)
			return -1;

		int left[] = new int[n];
		int right[] = new int[n];

		// scan from left to right
		int max = height[0];
		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			if (height[i] < max) {
				left[i] = max;
			} else {
				left[i] = height[i];
				max = height[i];
			}
		}

		// scan from right to left
		max = height[n-1];
		right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (height[i] < max) {
				right[i] = max;
			} else {
				right[i] = height[i];
				max = height[i];
			}
		}

		// calculate total
		for (int i = 0; i < n; i++) {
			result += Math.min(left[i], right[i]) - height[i];
		}

		return result;
	}

}
