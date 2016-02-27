package com.java.practise;

/*
 * Check the validity of Sudoku.If there are empty spaces then it is represented as 0
 */
public class CheckValidityOfSudoku {

	public static void main(String[] args) {
		int [][]sudoku={ {5,3,0,0,7,0,0,0,0},
						 {6,0,0,1,9,5,0,0,0},
						 {0,9,8,0,0,0,0,6,0},
						 {8,0,0,0,6,0,0,0,3},
						 {4,0,0,8,0,3,0,0,1},
						 {7,0,0,0,2,0,0,0,6},
						 {0,6,0,0,0,0,2,8,0},
						 {0,0,0,4,1,9,0,0,5},
						 {0,0,0,0,8,0,0,7,9}
			   		  };
	
		System.out.println(checkValidity(sudoku));
		int [][]sudoku2={    {6,3,9,5,7,4,1,8,2},
							 {5,4,1,8,2,9,3,7,6},
							 {7,8,2,6,1,3,9,5,4},
							 {1,9,8,4,6,7,5,2,3},
							 {3,6,5,9,8,2,4,1,7},
							 {4,2,7,1,3,5,8,6,9},
							 {9,5,6,7,4,8,2,3,1},
							 {8,1,3,2,9,6,7,4,5},
							 {2,7,4,3,5,1,6,9,8}
	   		  };	
		System.out.println(checkValidity(sudoku2));
		System.out.println(isValidSudoku(sudoku2));

	}
	/**
	 * The code written by me
	 * @param sudoku
	 * @return
	 */
	private static boolean checkValidity(int[][] sudoku) {
		//Checks rows
		for(int i=0;i<9;i++){
			boolean ar[]=new boolean[9];
			for(int j=0;j<9;j++){
				if(sudoku[i][j]!=0){
					if(ar[sudoku[i][j]-1]){
						return false;
					}
					else{
						ar[sudoku[i][j]-1]=true;
					}
				}
			}
		}
		
		//Checks column
			for(int i=0;i<9;i++){
					boolean ar[]=new boolean[9];
					for(int j=0;j<9;j++){
						if(sudoku[j][i]!=0){
							if(ar[sudoku[j][i]-1]){
								return false;
							}
							else{
								ar[sudoku[j][i]-1]=true;
							}
						}
					}
				}
			
			//Inner Boxes
		for(int block=0;block<9;block++){
			
			boolean ar[]=new boolean[9];
			for(int i=block/3 *3 ;i<block/3 *3 +3;i++){
				for(int j=block%3 *3 ;j<block%3 *3 +3;j++){
					if(sudoku[i][j]!=0){
						if(ar[sudoku[i][j]-1]){
							return false;
						}
						else{
							ar[sudoku[i][j]-1]=true;
						}
					}
				}
			}
		}
		return true;
		
	}
	/**
	 * The code online at http://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(int[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// check each column
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) {
					if (m[(int) (board[i][j] - 1)]) {
						return false;
					}
					m[(int) (board[i][j] - 1)] = true;
				}
			}
		}
	 
		//check each row
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != 0) {
					if (m[(int) (board[i][j] - 1)]) {
						return false;
					}
					m[(int) (board[i][j] - 1)] = true;
				}
			}
		}
	 
		//check each 3*3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != 0) {
						if (m[(int) (board[i][j] - 1)]) {
							return false;
						}
						m[(int) (board[i][j] - 1)] = true;
					}
				}
			}
		}
	 
		return true;
	}
}
