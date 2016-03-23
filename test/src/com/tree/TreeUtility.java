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
	
	
	public TreeNode createTreeNode2(){	
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		root.left.right.left = new TreeNode(5);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);
		root.right.left.right = new TreeNode(55);
		return root;
	}
}
