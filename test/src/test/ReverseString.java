package test;

/**
 * Reverse a String using Recursion
 * 
 * @author Jayaram
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("Hi there"));
	}

	private static String reverseString(String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

}
