/**
 * 
 */
package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * we will see about program to print all paths from root to leaf in a binary
 * tree in java Read more at
 * http://www.java2blog.com/2014/08/print-all-paths-from-root-to-leaf-in.html
 * 
 * Also there is a method which prints the sum of all nodes till the leaf nodes.
 * 
 * @author Jayaram
 *
 */
public class PrintNodesTillLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeUtility.createTreeNode2();

		TreeNode a[] = new TreeNode[10];

		PrintNodesTillLeaf obj = new PrintNodesTillLeaf();
		obj.printRootToLeafUsingIntegerArray(root, a, 0);

		System.out.println("--------********--------------");
		System.out.println("Now an approach to add the sum till the leaf nodes");
		obj.computeSumOfBranches(root, 0);
		System.out.println("--------********--------------");

		System.out.println("Printing using recursion on a list");
		// Recursion using List
		List<TreeNode> list = new ArrayList<TreeNode>();
		obj.printRootToLeafUsingListInRecursion(root, list);
		System.out.println("Hence you can see this approach does not work");

	}

	/**
	 * Use array and along with it use length counter to capture the
	 * backtracking component of it.
	 * 
	 * @param root
	 * @param list
	 * @param len
	 */
	public void printRootToLeafUsingIntegerArray(TreeNode root, TreeNode[] list, int len) {
		if (root == null) {
			return;
		}
		list[len++] = root;
		if (root.left == null && root.right == null) {
			printArray(list, len);
			return;
		}
		printRootToLeafUsingIntegerArray(root.left, list, len);
		printRootToLeafUsingIntegerArray(root.right, list, len);
	}

	/**
	 * Helper method for the printRootToLeafUsingIntegerArray.
	 * 
	 * @param list
	 * @param len
	 */
	private void printArray(TreeNode[] list, int len) {
		/* for (TreeNode node : list) { */
		for (int i = 0; i < len; i++) {
			System.out.print(list[i].val + "->");
		}
		System.out.println();
	}

	/**
	 * This approach does not help us in getting the list. This is because in a
	 * recursion stack, the list gets added and previous values are not removed.
	 * 
	 * @param root
	 * @param list
	 */
	public void printRootToLeafUsingListInRecursion(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		if (root.left == null && root.right == null) {
			printList(list);
			return;
		}
		printRootToLeafUsingListInRecursion(root.left, list);
		printRootToLeafUsingListInRecursion(root.right, list);
	}

	/**
	 * Used for iteration using List This will not be useful as we are using
	 * List and List is stored in heap. Helper method for the
	 * printRootToLeafUsingListInRecursion.
	 * 
	 * @param list
	 */
	private void printList(List<TreeNode> list) {
		for (TreeNode node : list) {
			System.out.print(node.val + "->");
		}
		System.out.println();
	}

	/**
	 * This method will compute the sum of all the node up till the leaf nodes.
	 * 
	 * @param root
	 * @param sum
	 */
	public void computeSumOfBranches(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			// If you don't want to print, you can add it to a global list.
			System.out.println(sum + root.val);
		}
		if (root.left != null) {
			computeSumOfBranches(root.left, sum + root.val);
		}
		if (root.right != null) {
			computeSumOfBranches(root.right, sum + root.val);
		}
	}

}
