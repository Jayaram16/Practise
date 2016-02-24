package com.tree;

import java.util.Iterator;
import java.util.Vector;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeTraversal().createTreeNode();
		int val1 = 110;
		int val2 = 175;
		// No need to arrange in val1 > val2
		LowestCommonAncestor obj = new LowestCommonAncestor();
		TreeNode node = obj.lowestCommonAncestorAsBST(root, val2, val1);
		System.out.println("The ancestor val is " + node.val);

		System.out.println("Using BT approach");
		TreeNode leastCommonNode = obj.lowestCommonAncestorForBT(root, val1, val2);
		if (leastCommonNode == null) {
			System.out.println("\n Either of the objects not found ");
		} else {
			System.out.println("\nThe ancestor value is " + leastCommonNode.val);
		}
	}

	// This assumes that val1 and val2 are always present in the tree.
	// If the vals are not present, then also it will give the answer
	private TreeNode lowestCommonAncestorAsBST(TreeNode root, int val1, int val2) {
		if (root == null) {
			return null;
		}
		if (root.val > val1 && root.val > val2) {
			return lowestCommonAncestorAsBST(root.left, val1, val2);
		}
		if (root.val < val1 && root.val < val2) {
			return lowestCommonAncestorAsBST(root.right, val1, val2);
		}
		return root;
	}

	// This is using Binary Tree approach where for every node, the path is
	// calculated from the root and then using a vector array, the common node
	// is returned
	// In this approach, the Space complexity is O(n) and O(n) time complexity.
	private TreeNode lowestCommonAncestorForBT(TreeNode root, int val1, int val2) {
		Vector<TreeNode> vector1 = new Vector<TreeNode>();
		Vector<TreeNode> vector2 = new Vector<TreeNode>();
		if (searchTreePath(root, val1, vector1)) {
			System.out.println("Path for val = " + val1);
			Iterator<TreeNode> iter = vector1.iterator();
			while (iter.hasNext()) {
				System.out.print(" -> " + iter.next().val);
			}
		}
		if (searchTreePath(root, val2, vector2)) {
			System.out.println("\nPath for val = " + val2 + " ");
			Iterator<TreeNode> iter = vector2.iterator();
			while (iter.hasNext()) {
				System.out.print(" -> " + iter.next().val);
			}
		}
		int counter = 0;
		if (vector1.size() == 0 || vector2.size() == 0) {
			return null;
		}
		while (true) {
			if (vector1.get(counter) == vector2.get(counter)) {
				counter++;
			} else {
				break;
			}
		}
		return vector1.get(counter - 1);
	}

	// Used to find the node along with the path.
	// Basically when going, the value is entered into the vector whereas if any
	// false value is encountered, the value is removed from the vector.
	private boolean searchTreePath(TreeNode root, int val, Vector<TreeNode> vector) {

		if (root == null) {
			return false;
		} else {
			vector.add(root);
			if (root.val == val) {
				return true;
			} else if (searchTreePath(root.left, val, vector) || searchTreePath(root.right, val, vector)) {
				return true;
			} else {
				vector.remove(vector.lastElement());
				return false;
			}
		}

	}

}
