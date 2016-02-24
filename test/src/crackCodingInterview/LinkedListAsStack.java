package crackCodingInterview;

import test.linkedList.ListNode;

public class LinkedListAsStack {

	private ListNode head;
	private int size = 0;

	public static void main(String[] args) {
		LinkedListAsStack obj = new LinkedListAsStack();
		obj.push(5);
		obj.push(15);
		obj.push(25);
		obj.push(35);
		obj.push(45);
		obj.pop();
		obj.pop();
		obj.pop();
		obj.peek();
		obj.pop();
		obj.pop();
		obj.pop();
		// Stack<Integer> s=new Stack<Integer>();
	}

	public void push(int a) {
		System.out.println("Pushing " + a);
		if (head == null) {
			head = new ListNode(a);
		} else {
			ListNode newNode = new ListNode(a);
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public int pop() {
		int val = 0;
		if (head == null) {
			val = 0;
		} else {
			val = head.val;
			head = head.next;
		}
		size--;
		System.out.println("poping " + val);
		return val;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return this.size;
	}

	public int peek() {
		int val=0;
		if (head == null) {
			val=0;
		} else {
			val= head.val;
		}
		System.out.println("peeking "+val);
		return val;
	}
}
