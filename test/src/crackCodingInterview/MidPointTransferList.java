package crackCodingInterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import test.linkedList.Node;
import test.linkedList.SingleLinkedList;

/**
 * Solved this midpoint transfer using two approaches. First is the normal
 * approach where the the keep track of elements after the half. Second is a
 * cleaner approach where in the elements after the second node is created into a new list and then merging takes place. 
 * 
 * @author Jayaram
 *
 */
public class MidPointTransferList {
	/// a1->a2->a3->a4->b1->b2->b3->b4 should be changed to
	// a1->b1->a2->b2->a3->b3->a4->b4
	// Complexity O(n) Time
	// O(1) Space
	public static void main(String[] args) {
		Node head = new Node(10);
		createList(head);
		System.out.println("Before ");
		SingleLinkedList.displayLinkedList(head);
		Node slow = findMiddle(head);
		System.out.println("Slow is " + slow.getValue());
		reArrange(head, slow);
		System.out.println("After ");
		SingleLinkedList.displayLinkedList(head);

		/**
		 * Trying to solve the problem using a new and easier approach
		 */
		System.out.println("Starting with second Approach");
		// Date changed on 27th March 2016
		// Break the node from the middle element
		Node headAgain = new Node(2);
		createNodeList(headAgain);

		Node middle = findMiddle(headAgain);

		Node secondHead = middle.getNext();
		middle.setNext(null);
		System.out.println("Displaying the split up of the nodes");
		display(headAgain);
		display(secondHead);
		Node headPointer = headAgain;
		System.out.println("Displaying the merging up of the nodes");

		mergeTwoList(headAgain, secondHead);
		display(headPointer);
	}

	private static void display(Node headPointer) {

		while (headPointer != null) {
			System.out.print("->" + headPointer.getValue());
			headPointer = headPointer.getNext();
		}
		System.out.println();
	}

	/**
	 * Will work for even number of nodes. If it there are odd number of nodes,
	 * then ask what needs to be done from the interviewer.I have ensured that
	 * first half will have more nodes than second half.
	 * 
	 * @param headAgain
	 * @param secondHead
	 */
	private static void mergeTwoList(Node headAgain, Node secondHead) {
		while (headAgain != null && secondHead != null) {
			Node temp = headAgain.getNext();
			headAgain.setNext(secondHead);
			secondHead = secondHead.getNext();
			headAgain.getNext().setNext(temp);

			headAgain = headAgain.getNext().getNext();
		}
		if (secondHead == null) {
			return;
		}
	}

	private static void createNodeList(Node headAgain) {
		headAgain.setNext(new Node(4));
		headAgain.getNext().setNext(new Node(6));
		headAgain.getNext().getNext().setNext(new Node(8));
		headAgain.getNext().getNext().getNext().setNext(new Node(10));
		headAgain.getNext().getNext().getNext().getNext().setNext(new Node(12));
		// headAgain.getNext().getNext().getNext().getNext().getNext().setNext(new
		// Node(14));

	}

	private static void reArrange(Node head, Node slow) {
		Node b = slow.getNext();
		Node pointer = head;
		int i = 0;
		// while(slow.getNext().getNext()!=null){
		/* while(b.getNext()!=null){ */
		// Each and every line below is very important
		while (slow != pointer) {
			Node temp = pointer.getNext();
			slow.setNext(b.getNext());
			pointer.setNext(b);
			b.setNext(temp);
			pointer = pointer.getNext().getNext();
			b = slow.getNext();
			;
			System.out.println("After iteration" + i++);
			SingleLinkedList.displayLinkedList(head);
		}
	}

	private static Node findMiddle(Node head) {
		Node fast = head.getNext();
		Node slow = head;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}

	public static void createList(Node pointerNode) {
		System.out.println("How many number you want to add to list");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner src = new Scanner(System.in);
		int count = src.nextInt();

		System.out.println("Enter " + count + " numbers");
		for (int i = 0; i < count; i++) {
			try {
				Node newNode = new Node(Integer.parseInt(br.readLine()));
				pointerNode.setNext(newNode);
				pointerNode = newNode;
			} catch (IOException e) {
				System.out.println("Found Error");
			}
		}
		pointerNode = null;
		src.close();
	}

}
