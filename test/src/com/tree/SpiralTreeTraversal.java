package com.tree;

import java.util.Stack;

/**
 * Spiral/Zigzag Level Order binary tree traversal in java. Read more at
 * http://www.java2blog.com/2014/08/spiralzigzag-level-order-traversal-of.html
 * 
 * Create an empty stack s and push root to it. while stack is not NULL Do
 * following Create a empty stack called tempStack. Pop a node from stack and
 * push it to tempStack depending on directionFlag Change directionFlag to
 * change the direction of traversal set stack=tempStack
 * 
 * 
 * @author Jayaram
 *
 */
public class SpiralTreeTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtility.createTreeNode2();
		traverseSpirally(root);
	}

	private static void traverseSpirally(TreeNode root) {
		if (root == null) {
			return;
		}
		boolean directionToLeft = true;
		Stack<TreeNode> outerStack = new Stack<TreeNode>();
		outerStack.push(root);
		while (!outerStack.isEmpty()) {

			Stack<TreeNode> innerStack = new Stack<TreeNode>();

			while (!outerStack.isEmpty()) {
				TreeNode node = outerStack.pop();
				System.out.print("->" + node.val);

				if (directionToLeft) {
					if (node.left != null) {
						innerStack.push(node.left);
					}
					if (node.right != null) {
						innerStack.push(node.right);
					}
				} else {
					if (node.right != null) {
						innerStack.push(node.right);
					}
					if (node.left != null) {
						innerStack.push(node.left);
					}
				}
			}
			directionToLeft = !directionToLeft;
			outerStack = innerStack;
		}

	}

}
