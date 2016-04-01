package test.linkedList;

/**
 * 
 * @author Jayaram
 *
 */
public class NodeUtility {

	public static ListNode createList(ListNode head) {
		head.val = 5;
		head.next = new ListNode(6);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(9);
		return head;
	}

	public static ListNode createList2(ListNode head) {
		head.val = 2;
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		//head.next.next.next=new ListNode(9);
		return head;
	}

	public static void displayList(ListNode node) {
		while (node != null) {
			System.out.print("->" + node.val);
			node=node.next;
		}
	}
}
