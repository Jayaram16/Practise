package test;

/**
 * Let 0 represent ‘A’, 1 represents ‘B’, etc. Given a digit sequence, count the
 * number of possible decodings of the given digit sequence.
 * 
 * @author Jayaram
 *
 */
public class CountDecoding {

	public static void main(String[] args) {

		System.out.println(countDecoding("12325"));
	}

	/**
	 * Uses the concept of dynamic programming.
	 * 
	 * @param str
	 * @return
	 */
	public static int countDecoding(String str) {
		int n = str.length();
		int ar[] = new int[n + 1];
		ar[0] = 1;
		ar[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (Integer.valueOf(str.charAt(i - 2)) < '2'
					|| (Integer.valueOf(str.charAt(i - 2)) == '2' && Integer.valueOf(str.charAt(i - 1)) <= '5')) {
				ar[i] = ar[i - 1] + ar[i - 2];
			} else {
				ar[i] = ar[i - 1];
			}
		}

		return ar[n];
	}
}
