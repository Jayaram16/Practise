package com.tree;

import java.util.Stack;

public class FindKthNodeInTree {
	static int count = 0;

	public static void main(String[] args) {
		TreeNode node = TreeUtility.createTreeNode2();
		System.out.println("The value is " + inOrderKthSearch(node, 7));
		System.out.println("The value is " + inOrderKthSearchUsingIteration(node, 4));
	}

	/**
	 * Using Recursion 
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	public static int inOrderKthSearch(TreeNode node, int k) {
		if (node == null) {
			return -1;
		}
		else {
			int val = inOrderKthSearch(node.left, k);

			count++;
			if (val != -1) {
				return val;
			}
			if (count == k) {
				return node.val;
			}
			return inOrderKthSearch(node.right, k);

			
		}
	}

	/**
	 * In Order Traversal using Iteration and finding the next node.
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	public static int inOrderKthSearchUsingIteration(TreeNode node, int k) {
		TreeNode p = node;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int counter = 0;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				counter++;
				if (counter == k) {
					return p.val;
				}
				p = p.right;
			}
		}
		return -1;
	}
}
