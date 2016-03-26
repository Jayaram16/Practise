package test.sort;

public class FindKthSmallestNumber {
	static QuickSort qs = new QuickSort();

	/**
	 * Given an array and a number k where k is smaller than size of array, we
	 * need to find the k’th smallest element in the given array. It is given
	 * that ll array elements are distinct. Using QuickSelect Approach. In case
	 * of finding the median, use middle element if number of elements are odd.
	 * If even, then find 2 middle elements and then get the average of it.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 12, 67, 73, 02 };
		System.out.println(findKthSmallestNumber(a, 0, a.length - 1, 4));
	}

	/**
	 * A good approach
	 * 
	 * @param a
	 * @param first
	 * @param last
	 * @param k
	 * @return
	 */
	private static int findKthSmallestNumber(int[] a, int first, int last, int k) {

		if (first >= 0 && first <= last) {
			int p = qs.partition(a, first, last, a[last]);
			if (p + 1 == k) {
				return a[p];
			}
			if (p + 1 < k) {
				return findKthSmallestNumber(a, p + 1, last, k);
			} else {
				return findKthSmallestNumber(a, first, p - 1, k);
			}
		}
		return 32727;
	}

}
