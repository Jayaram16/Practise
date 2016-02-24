package com.interviewbit;

public class CheckPalindrome {
	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * Example:
	 * 
	 * "A man, a plan, a canal: Panama" is a palindrome.
	 * 
	 * "race a car" is not a palindrome.
	 * 
	 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
	 * 
	 * @param a
	 * @return
	 */
	public int isPalindrome(String a) {

		a = a.toLowerCase();
		char charArray[] = a.toCharArray();
		//boolean flag = false;
		for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
			while (i < charArray.length && !isAlphaNumeric(charArray[i])) {
				i++;
			}
			while (j > 0 && !isAlphaNumeric(charArray[j])) {
				j--;
			}
			if (i >= j) {
				break;
			}
			if (!(charArray[i] == charArray[j])) {
				return 0;
			}
		}
		return 1;
	}

	private boolean isAlphaNumeric(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
			return true;
		else
			return false;
	}

	public static void main(String a[]) {
		System.out.println(new CheckPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		new CheckPalindrome();
		System.out.println(CheckPalindrome.isValidPalindrome("A man, a plan, a canal: Panama"));
	}

	
	public static boolean isValidPalindrome(String s){
		if(s==null||s.length()==0) return false;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
 

}
