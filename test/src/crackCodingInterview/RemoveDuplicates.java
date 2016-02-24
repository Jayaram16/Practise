package crackCodingInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import test.linkedList.Node;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Node head = new Node(5);
		createNodeList(head);
		System.out.println("Displaying before ");
		displayNode(head);
		removeDuplicatesUsingBuffer(head);
		System.out.println("Displaying After ");
		displayNode(head);
	}

	private static void removeDuplicates(Node head) {
		Node top = head;
		Node comp = top.getNext();
		Node prev = top;
		while (comp != null) {
			while (comp != null) {
				if (top.getValue() == comp.getValue()) {
					prev.setNext(comp.getNext());
					comp = comp.getNext();
				} else {
					comp = comp.getNext();
					prev = prev.getNext();
				}
			}
			top = top.getNext();
			if (top == null) {
				return;
			}
			comp = top.getNext();
			prev = top;
		}
	}

	private static void createNodeList(Node node) {
		node.setNext(new Node(121));
		node.getNext().setNext(new Node(112));
		node.getNext().getNext().setNext(new Node(12));
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

	public static void removeDuplicatesUsingBuffer(Node head) {
		Node top = head;
		Node runner = top.getNext();
		// Map<Integer,Integer> keyValue=new HashMap<Integer,Integer>();
		Set<Integer> keyValue = new HashSet<Integer>();
		keyValue.add(top.getValue());
		while (runner != null) {
			if (!keyValue.add(runner.getValue())) {
				top.setNext(runner.getNext());
				runner=runner.getNext();
			} else {
				top = top.getNext();
				runner = runner.getNext();
			}
		}
	}
}
