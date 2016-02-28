package com.tree;

import java.util.ArrayList;
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
		
		System.out.println("\nIn Order Traversal using loops");
		obj.traverseInOrderUsingLoop(root);
		
		System.out.println("\nPost Order Traversal using loops");
		obj.postorderTraversalUsingIterativeApproach(root);
		
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
			if (node2 != null) {
				System.out.print(" -> " + node2.val);
				nodeStack.push(node2.right);
				nodeStack.push(node2.left);
			}
		}
	}

	/**
	 * post order traversal using Iterative approach.
	 * 
	 * Here we would be first peeking and seeing the relation between the
	 * current node and previous to be traversed node.
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversalUsingIterativeApproach(TreeNode root) {

		ArrayList<Integer> lst = new ArrayList<Integer>();

		if (root == null)
			return lst;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;
		while (!stack.empty()) {
			TreeNode curr = stack.peek();

			// go down the tree.
			// check if current node is leaf, if so, process it and pop stack,
			// otherwise, keep going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				// prev == null is the situation for the root node
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.print(curr.val+"-->");
					lst.add(curr.val);
				}

				// go up the tree from left node
				// need to check if there is a right child
				// if yes, push it to stack
				// otherwise, process parent and pop stack
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					System.out.print(curr.val+"-->");
					lst.add(curr.val);
				}

				// go up the tree from right node
				// after coming back from right node, process parent node and
				// pop stack.
			} else if (curr.right == prev) {
				stack.pop();
				System.out.print(curr.val+"-->");
				lst.add(curr.val);
			}

			prev = curr;
		}

		return lst;
	}

	/**
	 * Traverse the Tree in InOrder Sequence.
	 * @param root
	 */
	public void traverseInOrderUsingLoop(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
		//	stack.push(root);
		}
		TreeNode p = root;
		  while(!stack.empty() || p != null){
			  
	            // if it is not null, push to stack
	            //and go down the tree to left
	            if(p != null){
	                stack.push(p);
	                p = p.left;
	 
	            // if no left child
	            // pop stack, process the node
	            // then let p point to the right
	            }else{
	                TreeNode t = stack.pop();
	               System.out.print(t.val+" -> ");
	              //  lst.add(t.val);
	                p = t.right;
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
