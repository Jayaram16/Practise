package com.interviewbit;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
 * @author Jayaram
 *
 */
public class ExcelColumnTitleToNumber {
	public int titleToNumber(String a) {
	
	String aUpperCase=a.toUpperCase();
	char []aChar=aUpperCase.toCharArray();
	int val=0;
	int powerVal=0;
	for(int i=aChar.length-1;i>=0;i--,powerVal++){
	    int temp=((aChar[i]-'A')+1);
	    val+=(temp*Math.pow(26,powerVal));
	    
	}
	    return val;
	}
}
