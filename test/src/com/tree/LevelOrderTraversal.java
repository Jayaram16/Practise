package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * Level Order Traversal of the given tree
 * @author Jayaram
 *
 */
public class LevelOrderTraversal {

	public static void main(String a[]) {
		TreeNode rootNode = new TreeNode(0);
		/*
		 * if(rootNode==null){ return; }
		 */
		LevelOrderTraversal object = new LevelOrderTraversal();
		object.createTreeNode(rootNode);
		object.levelOrderTraversal(rootNode);

	}

	/**
	 * @param rootNode:
	 *            RootNode of a given Binary tree
	 */
	public void createTreeNode(TreeNode rootNode) {
		rootNode.left = new TreeNode(1);
		rootNode.right = new TreeNode(2);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(4);
		rootNode.right.left = new TreeNode(5);
		rootNode.right.right = new TreeNode(6);
	}

	public void levelOrderTraversal(TreeNode rootNode) {
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>(); 
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			System.out.print("-->" + node.val);
		}
	}
}

class Node implements Comparable<Node>{
	int val;
	Node next;
	/*@Override
	public int compareTo(Object o) {
		Node oo=(Node)o;
	}*/
	@Override
	public int compareTo(Node o) {
		return Integer.valueOf(val).compareTo(Integer.valueOf(o.val));
	}
}
