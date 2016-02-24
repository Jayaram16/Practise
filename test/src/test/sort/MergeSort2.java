package test.sort;

public class MergeSort2 {

	public static void main(String[] args) {
		int a[] = { 2, 6, 71, 1, 8, 23, 11, 26,4,5,2,1 };
		callMergeSort(a, 0, a.length - 1);
	for(int bb:a){
		System.out.print(bb+" ");
	}
	}

	static private void callMergeSort(int[] a, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			callMergeSort(a, first, middle);
			callMergeSort(a, middle+1, last);
			merge(a, first, middle, last);
		}
	}

	private static void merge(int[] a, int first, int middle, int last) {
		// int i,j,k;
		//System.out.println("3"+3+3);
		String str="ffs";
		//str.in
		boolean v=new Boolean(true);
		int size1 = middle - first + 1;
		int size2 = last - middle;
		int[] n1 = new int[size1];
		int[] n2 = new int[size2];

		for (int i = 0; i < size1; i++) {
			n1[i] = a[first + i];
		}
		for (int i = 0; i < size2; i++) {
			n2[i] = a[middle + i+1];
		}
		int i = 0, j = 0, k = first;
		while (i < size1 && j < size2) {
			if (n1[i] < n2[j]) {
				a[k] = n1[i];
				i++;
				k++;
			} else {
				a[k] = n2[j];
				j++;
				k++;
			}
		}
		while (i < size1) {
			a[k] = n1[i];
			k++;
			i++;
		}
		while (j < size2) {
			a[k] = n2[j];
			k++;
			j++;
		}

	}
}
