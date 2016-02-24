package crackCodingInterview;

//Works brilliantly with O(n) time and O(1) space
public class CopyNodesWithRandomPointer {

	public static void main(String arg[]) {
		CopyNodesWithRandomPointer obj = new CopyNodesWithRandomPointer();
		NodeWith2Pointers first = obj.createNodeList();
		System.out.println("Before Transfer");
		obj.displaywithNextPointerOrRandomPointer(first);
		System.out.println("After Transfer");
		System.out.println("New list after cloning");
		obj.displaywithNextPointerOrRandomPointer(obj.cloneList(first));
		// System.out.println("First round: Original list after cloning");
		// Not required to print
		// obj.displaywithNextPointerOrRandomPointer(first);

	}

	private NodeWith2Pointers cloneList(NodeWith2Pointers first) {
		NodeWith2Pointers pointer = new NodeWith2Pointers();
		NodeWith2Pointers startPointer = pointer;
		while (first != null) {
			pointer.val = first.val;
			if (first.next != null)
				pointer.next = new NodeWith2Pointers();
			// Below 2 lines enough for justing copy next pointers.
			// first = first.next;
			// pointer = pointer.next;

			// NodeWith2Pointers for for copying next pointers and random
			// pointers.
			NodeWith2Pointers temp = first.next;
			pointer.random = first;
			first.next = pointer;

			first = temp;
			pointer = pointer.next;
		}
		pointer = startPointer;
		while (pointer != null) {
			pointer.random = pointer.random.random.next;
			pointer = pointer.next;
		}

		return startPointer;
	}

	private void displaywithNextPointerOrRandomPointer(NodeWith2Pointers first) {

		while (first != null) {
			/*
			 * System.out.print("Item value is " + first.val +
			 * " ; Next pointer pointer val is " + (first.next == null ? null :
			 * first.next.val) + " ; RandomPointer Value is " +
			 * (first.random==null?null:first.random.val)+" Object is "+first);
			 */
			System.out.print("Val " + first.val + " ; Object " + String.valueOf(first).split("@")[1]
					+ "; Next object is " + (first.next == null ? null : first.next.toString().split("@")[1])
					+ "; RandomPointer Object is "
					+ (first.random == null ? null : first.random.toString().split("@")[1]));

			first = first.next;
			System.out.println();
		}

	}

	public NodeWith2Pointers createNodeList() {
		NodeWith2Pointers first = new NodeWith2Pointers();
		NodeWith2Pointers local = first;
		for (int i = 0; i < 5; i++) {
			local.val = i * 10;
			local.next = new NodeWith2Pointers();
			local = local.next;
		}
		local.val = 50;
		local = first;
		NodeWith2Pointers secondPointer = local.next.next;
		while (local != null) {
			if (secondPointer == null) {
				secondPointer = first;
			}
			local.random = secondPointer;
			local = local.next;
			secondPointer = secondPointer.next;
		}
		return first;
	}
}

class NodeWith2Pointers {
	int val;
	NodeWith2Pointers next;
	NodeWith2Pointers random;
}
