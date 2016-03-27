package test.linkedList;

class RemoveDuplicatesInSortedList {
	public static void main(String a[]) {
		Node n = new Node(10);
		RemoveDuplicates.createNodeList(n);
		RemoveDuplicates.displayNode(n);
		System.out.println("After removing");
		RemoveDuplicates.displayNode(new RemoveDuplicatesInSortedList().removeDuplicates(n));
	}

	/**
	 * 
	 * @param current
	 * @return
	 */
	Node removeDuplicates(Node current) {
		Node prev = null;

		if (current == null || current.next == null) {
			return current;
		}
		Node head = current;
		while (current != null) {
			if (prev != null) {
				if (prev.value == current.value) {
					prev.next = current.next;
					current = current.next;
				} else {
					current = current.next;
					prev = prev.next;
				}
			} else {
				prev = current;
				current = current.next;
			}

		}
		return head;

	}

}