package com.java.practise;
/**
 * Remove a Character in a String
 * @author Jayaram
 *
 */
public class RemoveCharacterInString {

	public static void main(String[] args) {
		String a = "cabcdgcdgcfc";
		a="";
		String first = "";
		System.out.println(removeChar(first, a));

	}

	/**
	 * Remove a Character In a String using Recursion
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static String removeChar(String first, String second) {
		if (second.equals("")) {
			return first;
		}
		if (second.charAt(0) != 'c') {
			first = first + second.charAt(0);
		}
		return removeChar(first, second.substring(1));
		// return
	}

}
