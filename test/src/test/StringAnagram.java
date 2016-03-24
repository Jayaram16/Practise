package test;

public class StringAnagram {

	public static void main(String[] args) {
		String s = "abc";
		String t = "cab";
		System.out.println(isAnagram(s, t));
	}

	/**
	 * Complexity is O(n^2) and space is O(n) to save the boolean array
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.equals(t)) {
			System.out.println("StringAnagram.isAnagram()");
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}

		boolean[] tBoolean = new boolean[t.length()];
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		for (char a : sArray) {
			for (int i = 0; i < tArray.length; i++) {
				if (tArray[i] == a)
					if (!tBoolean[i]) {
						tBoolean[i] = true;
						break;
					}
			}
		}
		for (Boolean b : tBoolean) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This uses a complexity of O(1) where it is known that only small letters
	 * will be used and size of the array is 26.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram2(String s, String t) {
		if (s == t) {
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
			alphabet[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * There is a third way of doing it as well where in the all the Unicode
	 * values are considered. Here we need to consider a hashmap where key is
	 * Character and value is the number of times it is occurring. The time
	 * complexity is O(n) and space complexity is O(n)
	 */
}
