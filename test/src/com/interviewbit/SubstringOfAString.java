package com.interviewbit;

public class SubstringOfAString {
	/**
	 * Implement strStr().
	 * 
	 * strstr - locate a substring ( needle ) in a string ( haystack ). Try not
	 * to use standard library string functions for this question.
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * NOTE: Good clarification questions: What should be the return value if
	 * the needle is empty? What if both haystack and needle are empty? For the
	 * purpose of this problem, assume that the return value should be -1 in
	 * both cases. See Expected Output
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(final String haystack, final String needle) {
		if (haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty()) {
			return -1;
		}
		int sizeOfHayStack = haystack.length();
		int sizeOfNeedle = needle.length();

		int h = 0, n = 0;
		int counter = 0;
		while (h < sizeOfHayStack) {
			n = 0;
			while (n < sizeOfNeedle && h < sizeOfHayStack) {
				if (needle.charAt(n) != haystack.charAt(h)) {
					if (h - n > 0)
						h -= n + 1;
					else
						h = counter++;
					n = 0;

				} else {
					n++;
					h++;
					if (n == sizeOfNeedle) {
						return h - n;
					}
				}

			}
		}
		return -1;
	}

	public static void main(String a[]) {
		System.out.println(new SubstringOfAString()
				.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
	}
}
