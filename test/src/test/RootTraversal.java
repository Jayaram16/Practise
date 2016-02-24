package test;

public class RootTraversal {

	public static void main(String[] args) {
		Node parent = new Node(1);
		Node treeNode = createTree(parent);
		// System.out.println("Print 1st "+ treeNode.val);
		String s=new String(String.valueOf(parent.val));
		printAndCall(treeNode,s);
		// printAndCall(treeNode.right);
	}

	public static void printAndCall(Node node,String src) {
		if (node.left == null && node.right == null) {
			System.out.println(src);
		return;
		}
		
		if (node.left != null) {		
			src+=String.valueOf(node.val);
			printAndCall(node.left,src);
		}
		if (node.right != null) {
			src+=String.valueOf(node.val);
			printAndCall(node.right,src);
		}

	}

	public static void printAndCall2(Node node) {
		while (node != null) {

		}
	}

	public static Node createTree(Node node) {
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		return node;
	}

}
