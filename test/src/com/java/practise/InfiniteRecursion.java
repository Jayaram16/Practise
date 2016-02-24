package com.java.practise;

import java.util.ArrayList;
import java.util.List;

//: strings/InfiniteRecursion.java // Accidental recursion. // {RunByHand} import java.util.*;  
public class InfiniteRecursion {
	public String toString() {
		return " InfiniteRecursion address: " +/* this + */"\n";
	}

	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++)
			v.add(new InfiniteRecursion());
		System.out.println(v);
	}
} /// :~

//Takeaways: If the "this" is added, then we get exception because it goes in infinite loop
//Reason : + before this implies to the executor that this is a String call and makes a call toString() and hence goes in recursion