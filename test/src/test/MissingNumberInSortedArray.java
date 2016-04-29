/**
 * 
 */
package test;

/**
 * @author Jayaram
 *
 */
public class MissingNumberInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 5, 7, 8 };
		MissingNumberInSortedArray obj = new MissingNumberInSortedArray();
		System.out.println(obj.getMissingNumberInSortedArray(a, 0, a.length-1));
	}

	public int getMissingNumberInSortedArray(int a[], int first, int last) {
		int middle = 0;
		while (first < last) {
			middle = (first + last) / 2;
			// index not matching and hence needs to move left
			if (middle - first != a[middle] - a[first]) {
				last = middle;
				if (middle - first == 1 && a[middle] - a[first] > 1) {
					return a[middle] - 1;
				}
			}
			// index not matching and hence needs to move left
			if (last - middle != a[last] - a[middle]) {
				first = middle;
				if (last - middle == 1 && a[last] - a[middle] > 1) {
					return a[middle] + 1;
				}
			}
		}
		return -1;
	}
}
