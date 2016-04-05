/**
 * 
 */
package com.tree;

/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum to a given value. The path does not
 * need to start or end at the root or a leaf.
 * 
 * @author Jayaram
 *
 */
public class PrintNodesSumToPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeUtility.createTreeNode2();
		int sum = 55;
		int depth = depth(root);
		System.out.println("Depth is " + depth);
		int path[] = new int[depth];
		printSumToPath(root, path, 0, sum);
	}

	private static int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(depth(node.left), depth(node.right));
	}

	/**
	 * A good recursive way to search the path. The path array keeps track of
	 * nodes traversed till in that stack and looping condition will decide
	 * which sum matches the desired sum.
	 * 
	 * @param node
	 * @param path
	 * @param level
	 * @param sum
	 */
	public static void printSumToPath(TreeNode node, int[] path, int level, int sum) {
		if (node == null) {
			return;
		}
		path[level] = node.val;
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				printTreePath(path, i, level);
			}
		}
		printSumToPath(node.left, path, level + 1, sum);
		printSumToPath(node.right, path, level + 1, sum);
	}

	private static void printTreePath(int[] path, int start, int level) {

		for (int i = start; i <= level; i++) {
			System.out.print("->" + path[i]);
		}
		System.out.println();
	}

}
