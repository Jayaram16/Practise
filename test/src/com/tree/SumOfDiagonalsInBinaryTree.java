package com.tree;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Given a binary tree, print all diagonal sums.
 * 
 * @author Jayaram
 *
 */
public class SumOfDiagonalsInBinaryTree {

	public static void main(String[] args) {
		HashMap<Integer, Integer> diagonalSum = new HashMap<Integer, Integer>();
		TreeNode root = TreeUtility.createTreeNode2();
		new SumOfDiagonalsInBinaryTree().sumOfDiagonals(root, 0, diagonalSum);
		for (Entry<Integer, Integer> val : diagonalSum.entrySet()) {
			System.out.println("Diagonal: " + val.getKey() + " : Sum: " + val.getValue());
		}
	}

	/**
	 * The concept here is simple: If you are going on the left add +1 to the
	 * diagonal value. but on the right it will remain the same.
	 * 
	 * If you want the other side of diagonal, just add 1 on the right side and
	 * do not add any thing on the left side.
	 * 
	 * @param node
	 * @param diagonal
	 * @param diagonalSum
	 */
	void sumOfDiagonals(TreeNode node, int diagonal, HashMap<Integer, Integer> diagonalSum) {

		if (node == null)
			return;
		sumOfDiagonals(node.left, diagonal, diagonalSum);
		int val = 0;
		if (diagonalSum.containsKey(diagonal)) {
			val = diagonalSum.get(diagonal);
		}
		diagonalSum.put(diagonal, val + node.val);

		sumOfDiagonals(node.right, diagonal + 1, diagonalSum);

	}
}
