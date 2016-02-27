package com.interviewbit;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Given s = "Hello World",
 * 
 * return 5 as length("World") = 5.
 * 
 * Please make sure you try to solve this problem without using library
 * functions. Make sure you only traverse the string once.
 * 
 * @author Jayaram
 *
 */
public class LengthOfLastWordOfString {
	public static void main(String a[]) {
		LengthOfLastWordOfString obj = new LengthOfLastWordOfString();
		String ab = "sasd BCD dg";
		System.out.println("Length Using Library Function " + obj.lengthUsingFunctions(ab));
		System.out.println("Length Using Non Library Function" + obj.lengthOfLastWord(ab));
	}

	public int lengthOfLastWord(final String a) {
		if (a == null || a.length() == 0) {
			return 0;
		}
		int count = 0;
		int lastCount = 0;
		for (int i = 0; i < a.length(); i++) {
			char character = a.charAt(i);
			if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
				count++;
			}
			if (character == ' ') {
				if (count != 0) {
					lastCount = count;
				}
				count = 0;
			}
		}
		if (count != 0) {
			lastCount = count;
		}
		return lastCount;

	}

	public int lengthUsingFunctions(String a) {
		String ab[] = a.split(" ");
		String val = "";
		for (String abc : ab) {
			if (abc.trim().equals("")) {
				continue;
			} else {
				val = abc;
			}
		}
		if (val.equals("")) {
			return 0;
		}
		return val.length();
	}

}
