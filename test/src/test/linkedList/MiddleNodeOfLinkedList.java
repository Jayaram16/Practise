package test.linkedList;

/**
 * Find the middle element in the linkedList
 * 
 * @author Jayaram
 *
 */
class NodeLocal {
	NodeLocal next;
	int val;

	public NodeLocal(int val) {
		this.val = val;
	}
}

public class MiddleNodeOfLinkedList {
	public static void main(String a[]) {
		MiddleNodeOfLinkedList obj = new MiddleNodeOfLinkedList();
		NodeLocal head = new NodeLocal(-1);
		NodeLocal header = head;
		int count = 0;
		while (count != 9) {
			NodeLocal NodeLocal = new NodeLocal(count);
			head.next = NodeLocal;
			count++;
			head = NodeLocal;
		}
		NodeLocal out = obj.getMiddleVal(header);
		if (out != null) {
			System.out.println("The middle Val is " + out.val);
		}
	}

	public NodeLocal getMiddleVal(NodeLocal head) {
		if (head == null || head.next == null) {
			return null;
		}
		NodeLocal slowPointer = head;
		NodeLocal fastPointer = head.next;
		while (fastPointer != null && fastPointer.next != null) {

			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;

		}
		return slowPointer;
	}

}