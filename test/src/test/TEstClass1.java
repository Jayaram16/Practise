package test;

public class TEstClass1 {

	public static void main(String[] args) {

		Solution a = new Solution();

		System.out.println(a.hammingWeight2(5));
	}
}

class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				++count;
			}
			n = n / 2;
		}
		return count;
	}

	public int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;

	}

}
