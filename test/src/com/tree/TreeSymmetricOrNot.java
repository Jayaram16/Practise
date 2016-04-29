/**
 * 
 */
package com.tree;

/**
 * @author Jayaram
 *
 */
public class TreeSymmetricOrNot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = TreeUtility.createSymetricTree();
		if (root == null) {
			return;
		}
		System.out.println("Tree is symmetric " + checkIfSymetric(root.left, root.right));
	}

	static boolean checkIfSymetric(Node leftNode, Node rightNode) {
		if (leftNode == null && rightNode == null)
			return true;
		if (leftNode == null || rightNode == null)
			return false;
		if (leftNode.data != rightNode.data)
			return false;
		return checkIfSymetric(leftNode.right, rightNode.left) && checkIfSymetric(leftNode.left, rightNode.right);
		// return true;
	}
}
