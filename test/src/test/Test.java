package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Test {

	public final static void main(String[] args) {
		int av[] = { 1, 3, 67, 74, 62 };
		List<int[]> aa = Arrays.asList(av);
		String _52pickup;
		char as = 'f';
		int asf = as;
		char g = '\u0061';
		System.out.println("g is " + g);
		char \u0061 = '\u0061';
		// char 'a'='a'; will not work
		ch\u0061r f = 'g';
		// will not work ch'a'r f='g';

		System.out.println(0x10 + 10 + 010);

		try {
			System.out.println();
			File f32 = new File("");
			FileReader br = new FileReader(f32);
			// LEarnings: If there is no catchable exception in try block, then
			// no need to put the catch Exception because it will give
			// unreachable code.
		} catch (FileNotFoundException e) {

		}
	}

}

// Abstract or final but not both
abstract class Ad {
	transient int af;

	// Error statement :
	// synchronized int fs;
	final void as() {

	}
}
