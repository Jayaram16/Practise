package crackCodingInterview;

import test.linkedList.ListNode;

/**
 * Following works. But try using another approach where check each element with
 * the pivot. Any element less than the pivot should be moved to list1. Any
 * element greater than pivot should be moved to list2. Then simply merge the
 * two lists together.
 * 
 * @author Jayaram
 *
 */
public class PartitionLinkedListAroundPivot {

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		createNodeList(head);
		System.out.println("Before ");
		displayNode(head);
		partitionAgain(head, 112);
		// displayNode(head);

	}

	private static void displayNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "-->");
			head = head.next;
		}
		System.out.println();

	}

	private static void createNodeList(ListNode head) {
		head.next = new ListNode(121);
		head.next.next = new ListNode(112);
		head.next.next.next = new ListNode(1212);
		head.next.next.next.next = new ListNode(12);

	}

	// THis is working. PArtition using Cracking is not working
	public static ListNode[] partitionAgain(ListNode head, int x) {
		ListNode a[] = new ListNode[2];
		ListNode lower = new ListNode();
		ListNode greater = new ListNode();
		ListNode lowerPointer = lower;
		ListNode greaterPointer = greater;
		while (head != null) {
			if (head.val < x) {
				lower.next = head;
				head = head.next;
				lower = lower.next;
				lower.next = null;
			} else if (head.val >= x) {
				greater.next = head;
				head = head.next;
				greater = greater.next;
				greater.next = null;
			}

		}

		System.out.println("Printing head");
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		lower = lowerPointer;
		System.out.println("Printing lower");
		displayNode(lower);
		System.out.println("Printing greater");
		greater = greaterPointer;
		displayNode(greater);

		mergeBoth(lowerPointer.next, greaterPointer.next);
		return a;
	}

	// Not working yet
	public static ListNode[] partitionUsingCracking(ListNode head, int x) {
		ListNode a[] = new ListNode[2];

		// ListNode greater = new ListNode();
		ListNode lowerStart = null, lowerEnd = null;
		ListNode greaterStart = null, greaterEnd = null;
		while (head != null) {
			if (head.val < x) {
				if (lowerStart == null) {
					lowerStart = head;
					lowerEnd = lowerStart;
				} else {
					lowerEnd.next = head;
					lowerEnd = lowerEnd.next;
					lowerEnd.next = null;
				}
				head = head.next;
			} else if (head.val >= x) {
				if (greaterStart == null) {
					greaterStart = head;
					greaterEnd = greaterStart;
				} else {
					greaterEnd.next = head;
					greaterEnd = greaterEnd.next;
					greaterEnd.next = null;
				}
				head = head.next;
			}

		}

		System.out.println("Printing head");
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		// lowerEnd = lowerStart;
		System.out.println("Printing lower");
		displayNode(lowerStart);
		System.out.println("Printing greater");
		// greaterEnd = greaterStart;
		displayNode(greaterStart);

		mergeBoth(lowerStart, greaterStart);
		return a;
	}

	private static void mergeBoth(ListNode lowerPointer, ListNode greaterPointer) {
		ListNode originalPointer = lowerPointer;
		if (lowerPointer == null) {
			originalPointer = greaterPointer;
		} else {
			while (lowerPointer.next != null) {
				lowerPointer = lowerPointer.next;
			}
			lowerPointer.next = greaterPointer;
		}
		System.out.println("Merged List is ");
		displayNode(originalPointer);
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode top = head;
		boolean found = false;
		while (top != null) {
			if (top.val == x) {
				found = true;
				break;
			}
			top = top.next;
		}
		System.out.println("top.val is " + top.val);
		if (!found) {
			return head;
		}
		// After we get the value.Provided top is not the last node.
		// backNode for adding at the front of the node.
		// prev is to re allocate the changes after x and during transfer.
		ListNode prev = top;
		top = top.next;
		ListNode backNode = head;
		while (top != null) {
			if (top.val < x) {
				prev.next = top.next;
				ListNode temp = backNode.next;
				backNode.next = top;
				top.next = temp;
				top = prev.next;
				backNode = backNode.next;
			} else {
				prev = prev.next;
				top = top.next;
			}
		}
		return head;
	}
}
