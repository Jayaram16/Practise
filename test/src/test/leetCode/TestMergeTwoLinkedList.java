package test.leetCode;

import test.linkedList.ListNode;

public class TestMergeTwoLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		MergeTwoLinkedList l = new MergeTwoLinkedList();
		ListNode results = l.mergeTwoLists(l1, l2);
		display(results);
	}

	public static void display(ListNode result) {
		while (result != null) {
			System.out.print("-->" + result.val);
			result = result.next;
		}
	}

}
