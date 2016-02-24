package com.java.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * Two strings str1 and str2 are called isomorphic if there is a one to one
 * mapping possible for every character of str1 to every character of str2. And
 * all occurrences of every character in 'str1' map to same character in 'str2'
 * 
 * Examples:
 * 
 * Input: str1 = "aab", str2 = "xxy" Output: True 'a' is mapped to 'x' and 'b'
 * is mapped to 'y'.
 * 
 * Input: str1 = "aab", str2 = "xyz" Output: False One occurrence of 'a' in str1
 * has 'x' in str2 and other occurrence of 'a' has 'y'.
 * 
 * @author Jayaram
 *
 */
public class CheckIsomorphicStrings {

	public static void main(String[] args) {
		String str1 = "abb";
		String str2 = "xzz";
		System.out.println(checkIsomorphicStrings(str1, str2));
	}

	private static boolean checkIsomorphicStrings(String str1, String str2) {
		Map<Character, Character> dict = new HashMap<Character, Character>();

		if (str1.length() != str2.length()) {
			return false;
		} else {
			for (int i = 0; i <= str1.length() - 1; i++) {
				if (dict.containsKey(str1.charAt(i))) {
					if (dict.get(str1.charAt(i)) != str2.charAt(i)) {
						return false;
					} else {
						continue;
					}
				} else {
					dict.put(str1.charAt(i), str2.charAt(i));
				}
			}
			return true;
		}
	}

}
