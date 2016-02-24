package com.java.practise;

import java.util.Arrays;

public class SplitStrings {

	public static void main(String[] args) {

		String para = "This is ,unpre, : ?s sdf. dad This \n Huk{ ds";
		String original=para;
		char[] abc = { ';', '.', ',','?','\n','{','}','/','_','_','+','=','<','>',':','\\','\t','!','@','#','$','%','^','&','*','(',')' };
		for (int i = 0; i < abc.length; i++) {
			para=para.replace(abc[i], ' ');
		}
		original.replaceAll("[^a-zA-Z]", " ");
		System.out.println("Original is \n"+original);
		System.out.println("para after preprocessing \n"+para);
		String a[] = para.split(" ");
		String b[] = (Arrays.toString(a)).split(" ");
		System.out.println(a.length);
		for (String m : a) {
			System.out.print(m + " ");
		}
		System.out.println();
		System.out.println(b.length);
		for (String m : b) {
			System.out.print(m + " ");
		}
	}

}
