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

	/**
	 * 						40
	 * 				20		 		60
	 * 			10		30 		50		70
	 * 				  25			   55
	 * @return
	 */
	public static TreeNode createTreeNode2() {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		root.left.right.left = new TreeNode(25);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);
		root.right.left.right = new TreeNode(55);
		return root;
	}

	/**
	 * 
	 * 60 50 70 55
	 * 
	 * @return
	 */
	public static TreeNode createSubTreeNodeOf2() {
		TreeNode root = new TreeNode(60);
		root.left = new TreeNode(50);
		root.right = new TreeNode(70);
		root.left.right = new TreeNode(55);
		return root;
	}

	/**
	 * return binary search tree
	 * 
	 * @return
	 */
	public static Node createBinaryTree() {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(40);
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		// root.left.right.left = new Node(25);
		// root.right.left = new Node(50);
		root.right.right = new Node(50);
		// root.right.left.right = new Node(55);
		return root;
	}
	/**
	 * 
	 * 				10
	 * 			4		 4
	 * 		2		6 6		2
	 * @return
	 */
	public static Node createSymetricTree() {
		Node root = new Node(10);
		root.left = new Node(4);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.left.right = new Node(6);
		root.right.left = new Node(6);
		root.right.right = new Node(2);

		return root;
	}

}
