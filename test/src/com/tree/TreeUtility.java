package com.tree;

public class TreeUtility {
	public TreeNode createTreeNode() {
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(150);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(75);
		root.right.left = new TreeNode(125);
		root.right.right = new TreeNode(175);
		root.right.left.left = new TreeNode(110);
		return root;
	}
}
