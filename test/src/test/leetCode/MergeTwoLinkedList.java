package test.leetCode;

import test.linkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class MergeTwoLinkedList {

	public ListNode mergeTwoListsusingSameList(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode list = new ListNode(0);
		ListNode head = list;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				list.next = new ListNode(l1.val);
				list = list.next;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				list.next = new ListNode(l2.val);
				list = list.next;
				l1 = l2.next;
			}
		}
		list.next = l1 != null ? l1 : l2;
		return head.next;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode finalList = null;
		ListNode oldNode = null, top = null;
		int counter = 0;
		if (l1 == null && l2 == null) {
			return top;
		}
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				counter++;
				finalList = new ListNode(l1.val);
				if (counter == 1) {
					top = finalList;
					oldNode = finalList;
				}
				if (counter != 1) {
					oldNode.next = finalList;
					oldNode = oldNode.next;
				}
				finalList.next = null;
				l1 = l1.next;
			} else {
				finalList = new ListNode(l2.val);
				counter++;
				if (counter == 1) {
					top = finalList;
					oldNode = finalList;
				}
				if (counter != 1) {
					oldNode.next = finalList;
					oldNode = oldNode.next;
				}
				finalList.next = null;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			finalList = new ListNode(l1.val);
			counter++;
			if (counter == 1) {
				top = finalList;
				oldNode = finalList;
			}
			if (counter != 1) {
				oldNode.next = finalList;
				oldNode = oldNode.next;
			}
			finalList.next = null;

			l1 = l1.next;

		}
		while (l2 != null) {
			finalList = new ListNode(l2.val);
			counter++;
			if (counter == 1) {
				top = finalList;
				oldNode = finalList;
			}
			if (counter != 1) {
				oldNode.next = finalList;
				oldNode = oldNode.next;
			}
			finalList.next = null;
			l2 = l2.next;

		}
		return top;
	}
}