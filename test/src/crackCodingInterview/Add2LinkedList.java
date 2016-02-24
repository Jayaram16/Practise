package crackCodingInterview;


///Look at the other implementation and also try to solve the second part of the question using recursion

import test.linkedList.ListNode;

public class Add2LinkedList {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		createNode1(head1);
		ListNode head2 = new ListNode(2);
		createNode2(head2);
		ListNode head3 = add2Lists(head1, head2);
		displayListNode(head3);
	}

	private static void displayListNode(ListNode head3) {
		while (head3 != null) {
			System.out.print(" " + head3.val);
			head3 = head3.next;
		}
	}

	private static ListNode add2Lists(ListNode head1, ListNode head2) {
		int carryForward = 0;
		ListNode head3 = null, node3 = null, node4 = null;
		int count = 1;
		while (head1 != null || head2 != null || carryForward != 0) {
			int val1 = 0, val2 = 0;
			if (head1 != null) {
				val1 = head1.val;
			}
			if (head2 != null) {
				val2 = head2.val;
			}
			int value = val1 + val2 + carryForward;
			carryForward = value / 10;

			if (count == 1) {
				head3 = new ListNode(value % 10);
				head3.next = new ListNode(0);
				node3 = head3.next;
				count++;
			} else {
				node3.val = (value % 10);
				node3.next = new ListNode(0);
				node3 = node3.next;
			}

			if (head1 != null) {
				head1 = head1.next;
			}
			if (head2 != null) {
				head2 = head2.next;
			}

		}
		node3 = null;
		return head3;

	}

	private static void createNode1(ListNode node) {
		node.val = 1;
		node.next = new ListNode(2);
		//node.next.next = new ListNode(3);
	}

	private static void createNode2(ListNode node) {
		node.val = 1;
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
	}

}
