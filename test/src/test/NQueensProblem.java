/**
 * 
 */
package test;

import java.util.Arrays;

/**
 * NQueen Problem Backtracking with recursion
 * 
 * @author Jayaram
 *
 */
public class NQueensProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PositionPointer[] position = new PositionPointer[4];
		new NQueensProblem().nQueens(4, 0, position);
		System.out.println(Arrays.toString(position));
	}

	/**
	 * 
	 * @param n
	 * @param row
	 * @param positions
	 * @return
	 */
	public boolean nQueens(int n, int row, PositionPointer[] positions) {
		// Base condition very important
		if (n == row) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			boolean isSafe = true;
			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].column == col || (positions[queen].row - positions[queen].column == row - col)
						|| (positions[queen].column + positions[queen].row == row + col)) {
					isSafe = false;
					break;
				}
			}
			if (isSafe) {
				positions[row] = new PositionPointer(row, col);
				if (nQueens(n, row + 1, positions)) {
					return true;
				}
			}

		}
		return false;
	}

}

class PositionPointer {
	int row, column;

	PositionPointer(int row, int col) {
		this.row = row;
		this.column = col;
	}

	public String toString() {
		return (row + " " + column);
	}

}