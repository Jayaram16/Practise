package test;

public class MainCallingNode {
	static int counter = 1;

	public static void main(String[] args) {
		Node parent = new Node(10);
		Node treeNode = createTree(parent);
		/*
		 * String avc = "Hi There Satish we are working on it"; String a[] =
		 * avc.split(" "); for (int j = a.length-1; j >= 0; j--) {
		 * System.out.print(a[j]+" "); }
		 */
		/*
		 * Node cutNode=cutAndJoin(treeNode); System.out.println(
		 * "Value after 1 st cutting is "+cutNode.val); Node
		 * cutNode2=cutAndJoin(cutNode); System.out.println(
		 * "Value after 2nd cutting is "+cutNode2.val); Node
		 * cutNode3=cutAndJoin(cutNode2); System.out.println(
		 * "Value after 2nd cutting is "+cutNode3.val);
		 */
		while (treeNode.left != null) {
			treeNode = cutAndJoin(treeNode);
		}
		// cutAndJoin(treeNode.right);
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().totalMemory());

		// display(treeNode);
	}

	private static void display(Node cutNode3) {
		System.out.println(cutNode3);
		System.out.println(cutNode3.right);
		System.out.println(cutNode3.right.right);
		System.out.println(cutNode3.right.right.right);
		System.out.println(cutNode3.right.right.right.right);
		System.out.println(cutNode3.right.right.right.right.right);
		System.out.println(cutNode3.right.right.right.right.right.right);
	}

	private static void morrisAlgoInOrderTraver(Node treeNode) {

	}

	public static Node cutAndJoin(Node treeNode) {
		Node predecor = findPredecessor(treeNode.left);
		System.out.println(counter++ + " " + predecor.val);
		Node newParentNode = treeNode.left;
		treeNode.left = null;
		predecor.right = treeNode;
		return newParentNode;
	}

	public static Node findPredecessor(Node node) {
		if (node == null) {
			return null;
		}
		if (node != null && node.right == null) {
			return (node);
		} else
			return findPredecessor(node.right);
	}

	public static Node createTree(Node node) {
		node.left = new Node(8);
		node.right = new Node(12);
		node.left.left = new Node(6);
		node.left.right = new Node(9);
		node.right.left = new Node(11);
		node.right.right = new Node(14);
		node.left.left.left = new Node(5);
		node.left.left.right = new Node(7);
		node.right.right.left = new Node(13);
		node.right.right.right = new Node(15);
		return node;
	}
}
