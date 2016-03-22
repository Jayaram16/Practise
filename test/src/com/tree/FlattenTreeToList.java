/**
 * 
 */
package com.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jayaram
 *
 */
public class FlattenTreeToList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeUtility obj = new TreeUtility();
		TreeNode headNode = obj.createTreeNode();
		LinkedList<TreeNode> nodeList = flattenTree(headNode);
		new FlattenTreeToList().flattenInPlace(headNode);
		System.out.println();
		new TreeTraversal().traverseInOrderUsingLoop(headNode);
		System.out.println();
		display(nodeList);
	}

	private static void display(LinkedList<TreeNode> nodeList) {
		for (TreeNode node : nodeList) {
			System.out.print(node.val + "->");
		}
	}	

	/**
	 * Given a binary tree, flatten it to a linked list Flatten the tree to
	 * 100->50->25->75->150->125->110->175->
	 * 
	 * @param item
	 * @return
	 */
	private static LinkedList<TreeNode> flattenTree(TreeNode item) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
		nodeList.add(item);
		do {
			if (item.right != null) {
				stack.push(item.right);
			}
			if (item.left != null) {
				nodeList.add(item.left);
				item = item.left;
			} else if (item.left == null) {
				if (!stack.isEmpty()) {
					nodeList.add(item = stack.pop());
				} else
					item = null;
			}
		} while (!stack.isEmpty() || item != null);
		return nodeList;
	}

	/**  1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
              from 
                  1
        / \
       2   5
      / \   \
     3   4   6
	 * 
	 * @param root
	 */
	public void flattenInPlace(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}
}
