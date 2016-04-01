/**
 * 
 */
package test.linkedList;

/**
 * 
 * Use the concept of reversing the list1 and list2 and add them and then
 * reverse it again.
 * 
 * @author Jayaram
 *
 */
public class AddTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head1 = NodeUtility.createList(new ListNode());
		ListNode head2 = NodeUtility.createList2(new ListNode());

		ListNode head3 = addToLinkedList(head1, head2);
		NodeUtility.displayList(head3);

	}

	/**
	 * Parent method which does everything
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	private static ListNode addToLinkedList(ListNode head1, ListNode head2) {
		ListNode reversedList = reverseList(head1);
		ListNode reversedList2 = reverseList(head2);

		ListNode reversedList3 = addReversedList(reversedList, reversedList2);
		ListNode head3 = reverseList(reversedList3);
		return head3;
	}

	/**
	 * Adds the reversed List
	 * 
	 * @param reversedList
	 * @param reversedList2
	 * @return
	 */
	private static ListNode addReversedList(ListNode reversedList, ListNode reversedList2) {
		ListNode head3 = null;
		ListNode node3 = null;
		int sum = 0, carry = 0;
		while (reversedList != null && reversedList2 != null) {
			sum = reversedList.val + reversedList2.val + carry;
			carry = sum / 10;
			sum %= 10;
			if (head3 == null) {
				node3 = new ListNode(sum);
				head3 = node3;
				// node3 = node3.next;
			} else {
				node3.next = new ListNode(sum);
				node3 = node3.next;
			}
			reversedList = reversedList.next;
			reversedList2 = reversedList2.next;
		}

		ListNode remainingNode = null;
		if (reversedList != null) {
			remainingNode = reversedList;
		}
		if (reversedList2 != null) {
			remainingNode = reversedList2;
		}
		while (remainingNode != null) {
			sum = reversedList.val + carry;
			carry = sum / 10;
			sum %= 10;
			node3.next = new ListNode(sum);
			node3 = node3.next;
			remainingNode = remainingNode.next;
		}
		if (carry != 0) {
			node3.next = new ListNode(carry);

		}
		return head3;
	}

	/**
	 * Reverses the list
	 * 
	 * @param head1
	 * @return
	 */
	private static ListNode reverseList(ListNode head1) {
		ListNode current = head1;
		ListNode prev = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;

			// Moving to next pointer
			prev = current;
			current = next;
		}
		return prev;
	}

}
