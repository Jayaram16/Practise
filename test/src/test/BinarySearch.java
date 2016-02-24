package test;

public class BinarySearch {

	public static void main(String[] args) {

		System.out.println(new BinarySearch().binarySearch(new int[] { 1, 2, 3, 4, 6, 7, 80 }, 80));
	}

	private int binarySearch(int a[], int value) {
		boolean found = false;
		int n = a.length;
		int low = 0;
		int high = n - 1;
		int index = -10;
		do {
			int mid = (low + high) / 2 ;
			if (a[mid] == value) {
				found = true;
				index = mid;
			} else if (a[mid] < value) {
				low = mid+1 ;
			} else {
				high = mid-1;
			}
		} while (high >= low && !found);
		return index;
	}
}
