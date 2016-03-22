package test.linkedList;

/**
 * Given two singly linked lists A and B with sorted elements, merge them and
 * create a linked list C which is also sorted.
 * 
 * A: 2->5->7->11 
 * B: 3->4->8->11->12 
 * C: 2->3->4->5->7->8->11->11->12 
 * Asked in
 * interview
 * 
 * @author Jayaram
 *
 */
class SortList {

	public Node sortLists(Node head1, Node head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node p = head1;
		Node q = head2;
		Node head3 = null;
		Node prev1 = null;
		Node next2 = null;
		Node actualHead = null;
		while (p != null && q != null) {
			if (p.val <= q.val) {
				if (head3 == null) {
					head3 = p;
					actualHead = head1;
				} else {
					head3.next = p;
					head3 = head3.next;
				}
				p = p.next;
			} else {
				if (head3 == null) {
					head3 = q;
					actualHead = head2;
				} else {
					head3.next = q;
					head3 = head3.next;
				}
				q = q.next;
			}

		}
		if (q != null) {
			head3.next = q;
		}
		if (p != null) {
			head3.next = p;
		}
		return actualHead;

	}

	class Node {
		Node next;
		int val;
	}

}
