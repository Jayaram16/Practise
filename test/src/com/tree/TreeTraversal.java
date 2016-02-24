package com.tree;

import java.util.Stack;

// This class contains all the three traversals
//InOrder
//PreOrder
//PostOrder
public class TreeTraversal {
	Stack<TreeNode> nodeStack = new Stack<TreeNode>();

	public static void main(String[] args) {
		TreeTraversal obj = new TreeTraversal();
		TreeNode root = obj.createTreeNode();
		System.out.println("In Order Traversal ");
		obj.traverseInOrder(root);
		System.out.println("\nPre Order Traversal ");
		obj.traversePreOrder(root);
		System.out.println("\nPost Order Traversal ");
		obj.traversePostOrder(root);
		System.out.println("\nPre Order Traversal using loops");
		obj.traversePreOrderUsingLoop(root);
	}

	private void traverseInOrder(TreeNode node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" -> " + node.val);
			traverseInOrder(node.right);
		}
	}

	private void traversePreOrder(TreeNode node) {
		if (node != null) {
			System.out.print(" -> " + node.val);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	private void traversePostOrder(TreeNode node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" -> " + node.val);
		}
	}

	private void traversePreOrderUsingLoop(TreeNode node) {
		nodeStack.push(node);
		while (!nodeStack.isEmpty()) {
			TreeNode node2 = nodeStack.pop();
			if(node2!=null){
			System.out.print(" -> "+node2.val);
			nodeStack.push(node2.right);
			nodeStack.push(node2.left);
			}
		}
	}

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
