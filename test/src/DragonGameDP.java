import java.io.*;
import java.util.*;
// 4 0 0 0 0
// 4 0 0 0 1
//5 6 0 4 2 4 1 0 0 4
//1 0 0
//4 0 0 0
// a 
//1 a 
public class DragonGameDP {
	private static final int MAXIMUM_NUMBER = Integer.MAX_VALUE;

	public static void main(String args[]) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		
		List<Integer> input = readInput();
		int firstValue = 0;
		// if the input is invalid or first number is 0 return failure.
		if (input == null || input.isEmpty() || (firstValue = input.get(0)) == 0) {
			System.out.println("failure");
			return;
		}
		int sizeOfArray = input.size();
		// Base condition with first value greater than the size Of Array
		if (firstValue >= sizeOfArray) {
			System.out.println("0, out");
			return;
		}
		// List keeping track of min jumps
		List<Integer> jumpCount = new ArrayList<Integer>();
		// List keeping track of previous node from which jump was made.
		List<Integer> fromTracker = new ArrayList<Integer>();

		jumpCount.add(0, 0);
		fromTracker.add(0, 0);

		for (int i = 1; i < sizeOfArray; i++) {
			// Initially the jumpCounter is set to negative number
			jumpCount.add(i, MAXIMUM_NUMBER);
			// Initially set to self
			fromTracker.add(i, i);

			for (int j = 0; j < i; j++) {
				int jJumpCounter = 0;
				// If we were able to jump from the jth counter to atleast ith
				// or more than ith counter with the jumpCount not negative.
				if (i <= j + input.get(j) && (jJumpCounter = jumpCount.get(j)) != MAXIMUM_NUMBER) {
					// A smaller jump value is found
					if ((jumpCount.get(i)) > (jJumpCounter)) {
						jumpCount.set(i, jJumpCounter + 1);
						fromTracker.set(i, j);
					}/* else {
					}*/
					// Breaking as the shortest route till ith index has been
					// found.
					break;
				}
			}
		}

		/*for (int i : fromTracker) {
			System.out.print(i + " ");
		}
		System.out.println();
		// System.out.println("Minimum Value is" + jumpCount.get(sizeOfArray -
		// 1));
*/
		int n = sizeOfArray - 1;
		// Found that there is no shortest route.
		if (jumpCount.get(sizeOfArray - 1) == MAXIMUM_NUMBER || fromTracker.get(n) == n) {
			System.out.println("failure");
			return;
		}

		// Finding the route.
		int m = n, k = 0;
		 k = fromTracker.get(m);
		 String initialString="";
		 if(input.get(k)==(m-k)){
			 if(input.get(n)!=0){
				 initialString=", "+n+", out";	 
			 }
			 else{
				 System.out.println("failure");
					return;
			 }			 
		 }
		 else{
			 initialString=", out";
		 }
		StringBuilder sbr = new StringBuilder(initialString);
		while ((k = fromTracker.get(m)) != 0) {
			sbr.insert(0, ", " + String.valueOf(k));
			m = k;
		}
		sbr.insert(0, k);
	//	System.out.println("The string is " + sbr.toString());
		System.out.println(sbr.toString());
	}

	private static List<Integer> readInput() {
		List<Integer> input = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				String str = br.readLine();
				// System.out.println(str);
				if (str == null || str.trim().equals("") || str.trim().contains("\\n")) {
					break;
				}
				int n = Integer.parseInt(str);
				// to ensure only positive numbers are selected.
				if (n < 0) {
					return null;
				}
				input.add(n);
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (Exception e1) {
			return null;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return input;
	}

}