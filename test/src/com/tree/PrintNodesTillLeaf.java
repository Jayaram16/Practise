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
 * @author Jayaram
 *
 */
public class PrintNodesTillLeaf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = TreeUtility.createTreeNode2();
		
		  TreeNode a[] = new TreeNode[10]; new
		  PrintNodesTillLeaf().printRootToLeaf(root, a, 0);
		 
		// Recursion using List
		List<TreeNode> list = new ArrayList<TreeNode>();
		new PrintNodesTillLeaf().printRootToLeaf(root, list);
	}

	/**
	 * Use array and along with it use length counter to capture the
	 * backtracking component of it.
	 * 
	 * @param root
	 * @param list
	 * @param len
	 */

	public void printRootToLeaf(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		if (root.left == null && root.right == null) {
			printList(list);
			return;
		}
		printRootToLeaf(root.left, list);
		printRootToLeaf(root.right, list);
	}

	/**
	 * Used for iteration using List
	 * This will not be useful as we are using List and List is stored in heap. 
	 * @param list
	 */
	private void printList(List<TreeNode> list) {
		for (TreeNode node : list) {
			System.out.print(node.val + "->");
		}
		System.out.println();
	}

	public void printRootToLeaf(TreeNode root, TreeNode[] list, int len) {
		if (root == null) {
			return;
		}
		/* list.add(root); */
		list[len++] = root;
		if (root.left == null && root.right == null) {
			printArray(list, len);
			return;
		}
		printRootToLeaf(root.left, list, len);
		printRootToLeaf(root.right, list, len);
	}

	private void printArray(TreeNode[] list, int len) {
		/* for (TreeNode node : list) { */
		for (int i = 0; i < len; i++) {
			System.out.print(list[i].val + "->");
		}
		System.out.println();
	}

}
