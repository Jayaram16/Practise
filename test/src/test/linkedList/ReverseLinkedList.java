package test.linkedList;

/**
 * Reverse a LinkedList
 * 
 * @author Jayaram
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		Node node = head;
		int counter = 1;
		while (++counter != 7) {
			node.next = new Node(counter);
			node = node.next;
		}
		display(head);
		Node reversedHead = reverseLinkedList(head);
		display(reversedHead);
		head = reverseLinkedListUsingRecursion(reversedHead);
		display(head);

	}

	/**
	 * Above function will terminate when last node(2) 's next will be null.so
	 * while returning when you reach at node with value 1,If you closely
	 * observe node.next.next=node is actually setting 2->1(i.e. reversing the
	 * link between node with value 1 and 2) and node.next=null is removing link
	 * 1->2. So in each iteration, you are reversing link between two nodes.
	 * 
	 * 
	 * @param node
	 * @return
	 */
	private static Node reverseLinkedListUsingRecursion(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node remaining = reverseLinkedListUsingRecursion(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

	/**
	 * Reversing using Iterative Approach
	 * 
	 * @param head
	 * @return
	 */
	private static Node reverseLinkedList(Node head) {
		if (head == null) {
			return null;
		}

		Node prev = head;
		Node current = null;
		if (head.next != null) {
			current = head.next;
			prev.next = null;
		}
		while (current != null) {
			Node temp = current.next;
			current.next = prev;
			// Increment Node
			prev = current;
			current = temp;

		}
		return prev;
	}

	private static void display(Node head) {
		while (head != null) {
			System.out.print("->" + head.value);
			head = head.next;
		}
		System.out.println();

	}

	/**
	 * Logic for this would be: Have three nodes i.e previousNode,currentNode
	 * and nextNode 1) When currentNode is starting node, then previousNode will
	 * be null 2) Assign currentNode.next to previousNode to reverse the link.
	 * 3) In each iteration move currentNode and previousNode by 1 node.
	 * 
	 * Read more at
	 * http://www.java2blog.com/2014/07/how-to-reverse-linked-list-in-java.html#
	 * yjpaBL9A0qVwxzPb.99
	 * 
	 * @param currentNode
	 * @return Headnode of the reverse list
	 */

	// www.java2blog.com/2014/07/how-to-reverse-linked-list-in-java.html
	public static Node reverseLinkedListSimplerApproach(Node currentNode) {
		// For first node, previousNode will be null
		Node previousNode = null;
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.next;
			// reversing the link
			currentNode.next = previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

}
