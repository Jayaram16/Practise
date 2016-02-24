package com.java.practise;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileOperations {

	public static void main(String[] args) {
		// This represents the current directory.
		File path = new File(".");

		String[] a = path.list(new DirectoryFilenameFilter("class"));
		for (String b : a)
			System.out.println(b);
	}

}

class DirectoryFilenameFilter implements FilenameFilter {
	String pattern;

	DirectoryFilenameFilter(String pattern) {
		this.pattern = pattern;
	}

	// The below one is an example of using Strategy Design Pattern
	@Override
	public boolean accept(File currentDirectory, String words) {
		Pattern a = Pattern.compile(pattern);
		return a.matcher(words).matches();
		// return false;
	}

}
