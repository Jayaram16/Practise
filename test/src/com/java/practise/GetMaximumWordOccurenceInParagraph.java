package com.java.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * Read through a paragraph containing special characters, words, numbers and
 * others. Return the word which has the maximum occurrence in the paragraph. If
 * there are more than 1 words with more than one occurrence, return "" and -1;
 * @askedIn Google
 * @author Jayaram
 *
 */
public class GetMaximumWordOccurenceInParagraph {

	public static void main(String[] args) {
		String paragraph = "Hi there, This para  has special characters, d+,f. Along with this, para has"
				+ "\n and other \t special characters :.] and many more characters";
		String op[] = new GetMaximumWordOccurenceInParagraph().getMaximumWordOccurenceInParagraph(paragraph);
		System.out.println("The String with maximum occurence is \""+op[0]+"\"");
		System.out.println("The count of String with maximum occurence is "+op[1]);
	}

	public String[] getMaximumWordOccurenceInParagraph(String paragraph) {
		// \\s is used to include space in the regex and then replace non
		// characters with no space so that while splitting the string it will
		// be useful
		String paraWithoutSpecial = paragraph.replaceAll("[^a-zA-Z0-9\\s]", "");
		String[] wordList = paraWithoutSpecial.split(" ");
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for (int i = 0; i < wordList.length; i++) {

			String word = (wordList[i].trim());
			// The trim method returns "" if there are string with no data in
			// it.Hence the check.
			if (word.equals("")) {
				continue;
			}
			int count = 0;
			if (wordCount.containsKey(word)) {
				count = wordCount.get(word);
				wordCount.put(word, count + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
		// Uncomment for debugging the map
		/*
		 * for (String str : wordCount.keySet()) { System.out.println("Key : " +
		 * str + "  " + wordCount.get(str)); }
		 */
		int max = -1;
		int counter = 0;
		String maxWord = "";
		boolean isRepeated = false;
		for (String key : wordCount.keySet()) {
			counter = wordCount.get(key);
			if (counter == max) {
				isRepeated = true;
			} else if (counter > max) {
				max = counter;
				isRepeated = false;
				maxWord = key;
			}
		}
		if (isRepeated) {
			return new String[] { "", "-1" };
		}
		return new String[] { maxWord, String.valueOf(max) };
	}
}
