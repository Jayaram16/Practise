package com.interviewbit;

/**
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).



The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
              
 * @author Jayaram
 *
 */
public class UniquePathUsingFactorial {
	
	
	public static void main(String ap[]){
		UniquePathUsingFactorial a =new UniquePathUsingFactorial();
		System.out.println(a.fact(1-1));
		
		  long ms=a.fact(101-2);
		  long ss=a.fact(100-1);
		  long aa=a.fact(1-1);
		  System.out.println(ms/(ss*aa));
	}
	public int uniquePaths(int a, int b) {
	// The travel would be a-1 steps down and b-1 steps to the right.
	//The total steps would be a-1+b-1=a+b-2 steps.
	// ie it would (a+b-2)!/(a-1)!
	//Best way to solve it is below.
	int num=1;
	for(int i=a;i<=a+b-2;i++){
	    num*=i;
	    num/=(i-a+1);
	}
	return (int)num;
	
	//Using factorial way it is impossible as the size of the value increases drastically 
	
	// Normal factorial way!    
	}
    private long fact(int a){
        if(a<=1){
            return 1;
        }
        long val=1;
        while(a>1){
            val*=a;
            a--;
        }
        return val;
    }
}
