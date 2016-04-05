package com.interviewbit;

public class CompareVersionNumber {

	public static void main(String a[]) {
		System.out.println(new CompareVersionNumber().compareVersion("13.1", "13.0"));
	}

	public int compareVersion(String a, String b) {

		if (a.equalsIgnoreCase(b)) {
			return 0;
		}

		String[] firstString = a.split("\\.");
		String[] secondString = b.split("\\.");
		int len1 = firstString.length;
		int len2 = secondString.length;
		if (len1 == 0) {
			firstString = new String[1];
			firstString[0] = a;
			// firstString[0]=a;
			len1 = 1;
		}
		if (len2 == 0) {
			secondString = new String[1];
			secondString[0] = b;
			// secondString[0]=b;
			len2 = 1;

		}

		int minLen = Math.min(len1, len2);
		int i = 0;
		boolean flag = false;
		while (i < minLen) {
			//System.out.println(i);
			flag = false;
			//System.out.println(firstString[i]);
			//System.out.println(Integer.valueOf(firstString[i]));
			if (Integer.valueOf(firstString[i]) > Integer.valueOf(secondString[i])) {
				return 1;
			} else if (Integer.valueOf(firstString[i]) < Integer.valueOf(secondString[i])) {
				return -1;
			} else if (Integer.valueOf(firstString[i]) == Integer.valueOf(secondString[i])) {
				// firstString[i]=String.valueOf(Integer.valueOf(firstString[i]));
				// secondString[i]=String.valueOf(Integer.valueOf(secondString[i]));
				i++;
				flag = true;
			}
		}
	/*	if (flag) {
			return 0;
		}*/
		/*
		 * /*len1=firstString.length; len2=secondString.length;
		 */
		/*
		 * if(minLen==len1&&minLen==len2){ return 0; }
		 */
		// Indicates that len2 has some additional values which would increase
		// the version number and hence
		// returns a <b
		if (minLen == len1) {
			return -1;
		}
		// Indicates that len1 has some additional values which would increase
		// the version number and hence
		// returns a >b
		if (minLen == len2) {
			return 1;
		}
		return 0;
	}
}
