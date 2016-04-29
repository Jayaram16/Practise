/**
 * 
 */
package com.tree;

import java.util.Arrays;

/**
 * Serialize and Deserialize the BST
 * 
 * @author Jayaram
 *
 */
public class DeSerializationBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node rootOfBST = TreeUtility.createBinaryTree();

		serializePostOrder(rootOfBST);
		System.out.println("Post Order Traversal");
		System.out.println("Serialized Array");
		System.out.println(Arrays.toString(post));
		System.out.println("Deserialized order");
		Node rootOfBSTDeconstructed = constructBSTFromPostOrder(post, 0, post.length - 1);
		System.out.println("In Inorder form");
		DeSerializationBinaryTree.inorder(rootOfBSTDeconstructed);

		/*********************************************/
		System.out.println();
		serializePreOrder(rootOfBST);
		System.out.println("Pre Order Traversal");
		System.out.println("Serialized Array");
		System.out.println(Arrays.toString(pre));
		System.out.println("Deserialized order");
		Node rootOfBSTPreDeconstructed = constructBSTFromPreOrder(pre, 0, pre.length - 1);
		System.out.println(rootOfBSTPreDeconstructed);
		System.out.println("In Inorder form");
		DeSerializationBinaryTree.inorder(rootOfBSTPreDeconstructed);

	}

	static int post[] = new int[6];
	static int pre[] = new int[6];

	static int postIndex = 0, preIndex = 0;

	private static void serializePostOrder(Node rootOfBST) {
		if (rootOfBST != null) {
			serializePostOrder(rootOfBST.left);
			serializePostOrder(rootOfBST.right);
			post[postIndex++] = rootOfBST.data;
		}
	}

	private static void serializePreOrder(Node rootOfBST) {
		if (rootOfBST != null) {
			pre[preIndex++] = rootOfBST.data;
			serializePreOrder(rootOfBST.left);
			serializePreOrder(rootOfBST.right);
		}
	}

	/**
	 * Taken from GeeksForGeeks Algorithm goes like this now: Values[........]
	 * 
	 * 1. Last Element in array is the root of the whole tree
	 * 
	 * 2. Root = Values[values.length -1]
	 * 
	 * 3. break the remaining array into 3 parts =>
	 * [.....LEFT_SUB_TREE(LST)...,....RIGHT_SUB_TREE(RST)....,ROOT]
	 * 
	 * 4. Root.left-->LEFT_SUB_TREE
	 * 
	 * 5. Root.right-->RIGHT_SUB_TREE
	 *
	 * how to find where LST end and RST starts,
	 * 
	 * using properties of trees (all values in LST) < root and (all values in
	 * RST) > root
	 * 
	 * conditions I had to manage were:
	 * 
	 * if end < 0 return root as NULL, as there's nothing there after that
	 * 
	 * if start = end return start asap nothing to do there as well if cut off =
	 * -1 return null, nothing there as well
	 * 
	 */
	public static Node constructBSTFromPostOrder(int[] post, int start, int end) {
		if (start > end)
			return null;
		Node root = new Node(post[end]);
		int cut_off = getCutOff(post, start, end, post[end]);
		if (cut_off == -1)
			return null;
		root.left = constructBSTFromPostOrder(post, start, cut_off - 1);
		root.right = constructBSTFromPostOrder(post, cut_off, end - 1);
		return root;

	}

	/**
	 * Similar to the previous but subtle difference
	 * Not working in boundary condition
	 * @param pre
	 * @param start
	 * @param end
	 * @return
	 */
	public static Node constructBSTFromPreOrder(int[] pre, int start, int end) {
		if (start >= end)
			return null;
		Node root = new Node(pre[start]);
		int cut_off = getCutOffForPreOrder(pre, start, end, pre[start]);
		if (cut_off == -1)
			return null;
		root.left = constructBSTFromPreOrder(pre, start+1 , cut_off - 1);
		root.right = constructBSTFromPreOrder(pre, cut_off, end);
		return root;

	}

	/**
	 * Utility method to know where the cut off point of the BST is
	 * 
	 * @param post
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getCutOff(int[] post, int start, int end, int boundaryValue) {
		if (start == end)
			return start;
		for (int i = start; i < end; i++) {
			if (post[i] > boundaryValue)
				return i;
		}
		return -1;

	}

	/**
	 * Utility method to know where the cut off point of the BST is
	 * 
	 * @param post
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getCutOffForPreOrder(int[] post, int start, int end, int boundaryValue) {
		if (start == end)
			return start;
		for (int i = start+1; i <= end; i++) {
			if (post[i] > boundaryValue)
				return i;
		}
		return -1;

	}
}
