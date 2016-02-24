package crackCodingInterview;

import test.linkedList.Node;

public class DeleteNodeAccessToGivenNode {

	public static void main(String[] args) {
		Node head = new Node(5);
		createNodeList(head);
		System.out.println("Before ");
		displayNode(head);
		deleteNode(head.getNext().getNext().getNext());
		System.out.println("After ");
		displayNode(head);
	}

	private static void deleteNode(Node node) {
		if(node.getNext()==null){
			node=null;
			return;
		}
		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());
	}

	private static void createNodeList(Node node) {
		node.setNext(new Node(121));
		node.getNext().setNext(new Node(112));
		node.getNext().getNext().setNext(new Node(1212));
		node.getNext().getNext().getNext().setNext(new Node(12));
		//node.getNext().getNext().getNext().getNext().setNext(null);
	}

	private static void displayNode(Node n) {
		while (n != null) {
			System.out.print(n.getValue() + "-->");
			n = n.getNext();
		}
		System.out.println();

	}

}
