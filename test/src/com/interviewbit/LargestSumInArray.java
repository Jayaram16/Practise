package com.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*//Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/
public class LargestSumInArray {

	public static void main(String[] args) {
		
		int am[]={980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923, 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369, 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113, 302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684, 365, 470, 176, 910, 204, 324, 657, 161, 884, 623, 814, 231, 694, 399, 126, 426 };
		List<Integer> a = new ArrayList<Integer>();
		for(int i:am){
			a.add(i);
		}
/*		a.add(89);
		a.add(8);*/
		//a.add(89);
		//System.out.println(new LargestSumInArray().largestNumber(a));
		System.out.println(new LargestSumInArrayUsingComparator().largestNumber(a));
	}

	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {

		HashMap<Integer, List<Integer>> bucketList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i <= a.size() - 1; i++) {
			int num = a.get(i);
			int val = getDigit(a.get(i), -1);
			if (bucketList.containsKey(val)) {
				List<Integer> temp = placeAppropriately(bucketList.get(val), num);
				bucketList.put(val, temp);
			} else {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(num);
				bucketList.put(val, temp);
			}

		}
		StringBuilder str = new StringBuilder();
		for (int i = 9; i > 0; i--) {
			if (bucketList.containsKey(i)) {
				List temp = bucketList.get(i);
				for (int j = 0; j <= temp.size() - 1; j++) {
					str.append(temp.get(j));
				}
			}

		}
		return str.toString();
	}

	// lower is assumed to be num. So if it is not the case, we will switch.
	public List<Integer> placeAppropriately(List<Integer> tuple, int num) {
		for (int i = 0; i < tuple.size() - 1; i++) {
			boolean lower_Num = false;
			int lowerVal = 0;
			int upperVal = 0;
			int num2 = tuple.get(i);
			if (num2 == num) {
				tuple.add(i + 1, num);
				return tuple;
			}

			int count1 = getCountDigits(num);
			int count2 = getCountDigits(num2);
			if (count1 == count2) {
				if (num > num2) {
					tuple.add(i + 1, num2);
					tuple.set(i, num);
					return tuple;
				} else {
					continue;
				}
			}

			int lower = count1 < count2 ? count1 : count2;
			int upper = count1 > count2 ? count1 : count2;
			lowerVal = num2;
			upperVal = num;
			if (lower != count2) {
				lower_Num = true;
				lowerVal = num;
				upperVal = num2;
			}
			while (lower < upper) {
				int mod = lowerVal % 10;
				lowerVal = lowerVal + mod;
				lower++;
			}
			if (lowerVal > upperVal && lower_Num) {
				tuple.add(i + 1, num2);
				tuple.set(i, num);
				return tuple;

			} /*
				 * else if(lowerVal>upperVal) else{ tuple.add(i+1,lowerVal);
				 * tuple.set(i,upperVal); }
				 */

		}
		tuple.add(num);
		return tuple;
	}

	public int getCountDigits(int num) {
		int count = 1;
		while (num / 10 != 0) {
			num = num / 10;
			count++;
		}
		return count;
	}

	// if times =-1, then continue till you find
	public int getDigit(int num, int times) {
		int val = 0;
		while (num / 10 != 0) {
			num = num / 10;
		}
		val = num;
		return val;
	}

}

	 class LargestSumInArrayUsingComparator {
		// DO NOT MODIFY THE LIST
		public String largestNumber(final List<Integer> a) {
	    List<Integer> b=new ArrayList<Integer>(a);
	    Collections.sort(b, new MyComparator());
	    StringBuilder str=new StringBuilder();
	    for(int i=0;i<b.size();i++)
	        str.append(b.get(i));
	    
	    return str.toString();
	    }
	}

	 class MyComparator implements Comparator<Integer>{
	    public int compare(Integer a, Integer b){
	        String XY=String.valueOf(a)+String.valueOf(b);
	        String YX=String.valueOf(b)+String.valueOf(a);
	        int xy=Integer.valueOf(XY);
	        int yx=Integer.valueOf(YX);
	        if(xy>yx){
	        	return -1;
	        }
	        else if(yx<xy){
	        	return 1;
	        }
	        else 
	        	return 0;
	        
	    }
	}


