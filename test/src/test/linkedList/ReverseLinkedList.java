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

	private static Node reverseLinkedListUsingRecursion(Node reversedHead) {
		// TODO Auto-generated method stub
		return null;
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

	
}
