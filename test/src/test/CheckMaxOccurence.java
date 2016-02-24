package test;

import java.util.Map;
import java.util.HashMap;

public class CheckMaxOccurence {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 3, 4, 3 };
		System.out.println(countOccurence(nums));
		System.out.println("Count using Moore " + countUsingMooreVoting(nums));
		int length = args.length;
	}

	public static int countOccurence(int[] nums) {
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			if (counter.containsKey(nums[i])) {
				count = counter.get(nums[i]);
			}
			counter.put(nums[i], ++count);
		}
		for (int j : counter.keySet()) {
			if (counter.get(j) > nums.length / 2) {
				return j;
			}
		}
		return 0;
	}

	public static int countUsingMooreVoting(int[] nums) {
		int counter = 1;
		int val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (counter != 0) {
				if (val == nums[i]) {
					++counter;
				} else {
					--counter;
				}
			} else {
				val = nums[i];
				counter = 1;
			}
		}
		System.out.println("counter is " + counter);
		return val;
	}
}
