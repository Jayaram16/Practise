package crackCodingInterview;

import test.linkedList.ListNode;
//This checks whether the list contains a cycle or not.
//Used a concept of fast pointer and slow pointer.
public class CheckListIsCyclicOrNot {

	public static void main(String[] args) {
		ListNode list=new ListNode(2);
		ListNode list1=new ListNode(21);
		ListNode list2=new ListNode(22);
		ListNode list3=new ListNode(23);
		ListNode list4=new ListNode(24);
		ListNode list5=new ListNode(25);
		list.next=list1;
		list1.next=list2;
		list2.next=list3;
		list3.next=list4;
		list4.next=list5;
		//list5.next=list2;
		CheckListIsCyclicOrNot obj=new CheckListIsCyclicOrNot();
		System.out.println(obj.checkCyclicOrNot(list));
	}

	public boolean checkCyclicOrNot(ListNode list) {
		ListNode fast = list;
		ListNode slow = list;

		boolean found = false;
		while (fast.next != null && fast.next.next != null && !found) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				found = true;
			} else {

			}
		}
		return found;

	}
}
