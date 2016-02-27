package test.linkedList;

public class Node {
	 int value;
	Node next;

	public Node(int value) {
		this.setValue(value);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
