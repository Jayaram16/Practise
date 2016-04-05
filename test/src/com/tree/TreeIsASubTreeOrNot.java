package com.tree;

/**
 * Given two trees check whether the given tree is a subtree of another.
 * 
 * @author Jayaram
 *
 */
public class TreeIsASubTreeOrNot {
	/**
	 * This has a complexity of O(mn)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode bigTree = TreeUtility.createTreeNode2();
		TreeNode smallTree = TreeUtility.createSubTreeNodeOf2();

		System.out.println(isASubTreeOrNot(bigTree, smallTree));
	}

	/**
	 * This is the actual method. The base cases are important.
	 * 
	 * @param bigTree
	 * @param smallTree
	 * @return
	 */
	private static boolean isASubTreeOrNot(TreeNode bigTree, TreeNode smallTree) {
		if (smallTree == null) {
			return true;
		}
		if (bigTree == null) {
			return false;
		}
		if (isIdentical(bigTree, smallTree)) {
			return true;
		}

		return (isASubTreeOrNot(bigTree.left, smallTree) || isASubTreeOrNot(bigTree.right, smallTree));
	}

	/**
	 * Check whether two trees are identical or not. The base cases are
	 * important.
	 * 
	 * @param big
	 * @param small
	 * @return
	 */
	private static boolean isIdentical(TreeNode big, TreeNode small) {
		if (big == null && small == null) {
			return true;
		}
		if (big == null || small == null) {
			return false;
		}

		if (big.val == small.val) {
			return isIdentical(big.left, small.left) && isIdentical(big.right, small.right);
		}

		return false;
	}

}
