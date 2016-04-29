package com.java.practise;

/**
 * Search an element in a sorted and rotated array
 * 
 * 1) Find middle point mid = (l + h)/2
	2) If key is present at middle point, return mid.
	3) Else If arr[l..mid] is sorted
	    a) If key to be searched lies in range from arr[l]
	       to arr[mid], recur for arr[l..mid].
	    b) Else recur for arr[mid+1..r]
	4) Else (arr[mid+1..r] must be sorted)
	    a) If key to be searched lies in range from arr[mid+1]
	       to arr[r], recur for arr[mid+1..r].
	    b) Else recur for arr[l..mid] 
 * @author Jayaram
 *
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = { 6, 7, 1, 2, 3, 4, 5 };
		int k = 1;
		System.out.println(new SearchInRotatedSortedArray().findElement(a, k, 0, a.length - 1));
	}

	int findElement(int a[], int k, int first, int last) {
		int mid = 0;
		while (first <= last) {
			mid = (first + last) / 2;
			if (a[mid] == k) {
				return mid;
			}
			if (a[first] == k) {
				return first;
			}
			if (a[last] == k) {
				return last;
			}
			// That means first half is sorted
			if (a[first] <= a[mid]) {
				if (k < a[mid]) {
					// Go left
					last = mid - 1;
				} else {
					// go right
					first = mid + 1;
				}
			} // Second half is sorted
			else {
				if (k > a[mid]) {
					first = mid + 1;
				} else {
					last = mid - 1;
				}
			}
		}
		return -1;
	}
}
