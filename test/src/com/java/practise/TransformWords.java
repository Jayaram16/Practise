package com.java.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings transform one string to another in such a way that words
 * are present in the dictionary.
 * 
 * @author Jayaram
 *
 */
public class TransformWords {
	private static Set<String> dict = new HashSet<String>();

	public static void main(String[] args) {
		dict.add("CAT");
		dict.add("COT");
		dict.add("DOT");
		dict.add("DOG");
		String srcStr = "CAT";
		String destStr = "DOG";
		int index = 0;
		List<String> listOfWords = new ArrayList<String>();
		char sourceArray[] = srcStr.toCharArray();
		listOfWords.add(srcStr);

		// you can check at the begining itself whether destination word exists
		// or not
		if (!checkInDictionary(destStr)) {
			System.out.println("The final word is not in dictionary");
			return;
		}
		tranformWords(sourceArray, destStr, index, listOfWords);
		// System.out.println(String.valueOf(sourceArray));
		if (!String.valueOf(sourceArray).equals(destStr)) {
			System.out.println("NOT found");
			return;
		} else {
			// listOfWords.add(String.valueOf(sourceArray));
			System.out.println(listOfWords);
		}
	}

	// Works for positive cases when the destination word exists. and would work
	// if the destination word is not in dictionary if we do a check at the
	// beginning that dest word is not there.
	private static void tranformWords(char[] srcStr, String destStr, int index, List<String> listOfWords) {
		if (String.valueOf(srcStr).equals(destStr)) {
			return;
		} else {
			if (index > srcStr.length - 1) {
				index = 0;
			}
			if (srcStr[index] != destStr.charAt(index)) {
				char temp = srcStr[index];
				srcStr[index] = destStr.charAt(index);
				if (!checkInDictionary(String.valueOf(srcStr))) {
					srcStr[index] = temp;
				} else {
					listOfWords.add(String.valueOf(srcStr));
				}
				tranformWords(srcStr, destStr, ++index, listOfWords);
			} else {
				tranformWords(srcStr, destStr, ++index, listOfWords);
			}
		}
	}

	private static boolean checkInDictionary(String source) {
		if (dict.contains(source)) {
			return true;
		}
		return false;

		/*
		 * for (String a : dict) { if (a.equalsIgnoreCase(source)) { return
		 * true; } } return false;
		 */
	}
}
