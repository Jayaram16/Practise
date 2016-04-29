package com.tree;

/**
 * Serialization using only 1 traversal by using extra character.
 * 
 * @author Jayaram
 *
 */
public class DeSerializationBinaryTree {
	public static String serialize(Node root) {
		if (root == null)
			return "# ";
		else {
			return root.data + " " + serialize(root.left) + serialize(root.right);
		}
	}

	public static Node deserialize(String res) {
		String[] tokens = res.trim().split("\\s+");
		return deserialize(tokens);
	}

	static int index = 0;

	private static Node deserialize(String[] stringArray) {
		if (index >= stringArray.length)
			return null;
		if (stringArray[index].equals("#")) {
			index++;
			return null;
		}

		int value = Integer.parseInt(stringArray[index]);
		Node tree = new Node(value);
		index++;
		tree.left = deserialize(stringArray);
		tree.right = deserialize(stringArray);
		return tree;
	}

	 static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print("-> " + root.data);
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(30);
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(50);
		Node node4 = new Node(45);
		Node node5 = new Node(35);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;

		System.out.println(serialize(root));
		Node node = deserialize("30 10 50 # # # 20 45 # # 35 # # ");
		inorder(node);
	}
}