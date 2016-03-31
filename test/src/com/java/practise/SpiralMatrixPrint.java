/**
 * 
 */
package com.java.practise;

/**
 * Given a 2D array, print it in spiral form. See the following examples.

Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
Simple and Sweet approach shown below
 *
 * O(mn) complexity
 * @author Jayaram
 *
 */
public class SpiralMatrixPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][]={ {1,2,3,4,5},
					{6,7,8,9,10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}	
					};
			spiralRotateMatrix(a);
	}
	/**
	 * Assuming no need of boundary conditions
	 * @param a
	 */
	private static void spiralRotateMatrix(int[][] a) {
		int col=a.length;
		int rows=a[0].length;
		int left=0,right=col-1,top=0,bottom=rows-1;
		int count=0;
		int turn=0;
		
		
		int i=0,j=0;
		int n=col*rows;
		while(count<n){
			
			System.out.print(" "+a[i][j]);
			//This turn is for going right
			if(turn==0){
				if(j!=right){
				//Move right
					j++;
				}
				else{
					//Turn down
					turn =1;
					i++;
					//indicates top row has been completed and hence increment it
					top++;
				}				
			}
			//This turn is for going down
			else if(turn == 1){
				if(i!=bottom){
					//Go bottom
					i++;
				}
				else{
					//Turn left
					turn =2;
					//going left means decreasing column counter
					j--;
					//indicates the right column has been completed.
					right--;
				}
			}
			//This turn is for going left again
			else if (turn == 2){
				if(j!=left){
					j--;
				}
				else{
					//Turn up
					turn=3;
					//decreasing i means going up row. 
					i--;
					//bottom row has been completed
					bottom--;
				}
			}
			//This turn is for going up
			else{
				if(i!=top){
					i--;
				}
				else{
					//Turn right
					turn=0;
					//Go right
					j++;
					//left limit is increased.
					left++;
				}
			}
		count++;	
		}
		
		
		
	}

}
