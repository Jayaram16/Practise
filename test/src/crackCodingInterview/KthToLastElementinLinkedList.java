package crackCodingInterview;

import test.linkedList.Node;

public class KthToLastElementinLinkedList {

	public static void main(String[] args) {
		Node head = new Node(5);
		createNodeList(head);
		System.out.println("Before ");
		displayNode(head);
		System.out.println("The value is " + kToLastElement(head, 7));
	}

	private static int kToLastElement(Node head, int k) {
		Node fastRunner = head;
		Node slowRunner = head;
		int i = 0;
		while (i < k) {
			if (fastRunner == null) {
				System.out.println("No such value due to insufficient length");
				return -327683;
			}
			fastRunner=fastRunner.getNext();
			i++;
		}
		while(fastRunner!=null){
			fastRunner=fastRunner.getNext();
			slowRunner=slowRunner.getNext();
		}
		return slowRunner.getValue();
	}

	private static void createNodeList(Node node) {
		node.setNext(new Node(121));
		node.getNext().setNext(new Node(112));
		node.getNext().getNext().setNext(new Node(1212));
		node.getNext().getNext().getNext().setNext(new Node(12));
		node.getNext().getNext().getNext().getNext().setNext(null);
	}

	private static void displayNode(Node n) {
		while (n != null) {
			System.out.print(n.getValue() + "-->");
			n = n.getNext();
		}
		System.out.println();

	}
}
