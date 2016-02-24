package com.java.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// This is used when we know there would be only spaces in between
public class DuplicateWordSearcher {

	public static void main(String[] args) {

		String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";

		List<String> list = Arrays.asList(text.split(" "));

		// Set<String> uniqueWords = new HashSet<String>(list);
		/*
		 * for (String word : uniqueWords) { System.out.println(word + ": " +
		 * Collections.frequency(list, word)); }
		 */
		Map<String, Integer> keySet = new HashMap<String, Integer>();
		// Other way would be use HashMap
		for (String word : list) {
			if (!keySet.containsKey(word)) {
				keySet.put(word, 1);
			} else {
				int val = keySet.get(word);
				keySet.put(word, ++val);
			}
		}
		for (String key : keySet.keySet()) {
			System.out.println(key + keySet.get(key));
		}
		//
		int max = 0;
		String word = null;
		// Useful if using to find single largest value;
		for (String key : keySet.keySet()) {
			if (max < keySet.get(key)) {
				max = keySet.get(key);
				word = key;
			}
		}
		System.out.println("Word " + word + " occurs " + max + " times");
		// */

		// If we have more than one largest values
		// we need to sort it
		Collections.sort(list);
		int maxi = 0;
		String wordVal="";
		String prevVal = list.get(0);
		int count = 0;
		for (int i = 1; i < list.size(); i++) {
			if (prevVal == list.get(i)) {
				count++;
			} else {
				count = 0;
			}
			if (count > max) {
				maxi = count;
				wordVal = list.get(i);
			}
		}
		System.out.println(wordVal +" "+ maxi);
	}
}
/*
 * Output:
 * 
 * ft: 1 f: 7 g: 2 d: 5 e: 1 b: 1 c: 1 a: 3 wed: 1 sd: 1 se: 1 j: 3 ws: 1 k: 2
 * h: 2 w: 1 v: 1 s: 4 r: 1 gh: 1 x: 1
 */