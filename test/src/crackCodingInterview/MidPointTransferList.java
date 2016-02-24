package crackCodingInterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import test.linkedList.Node;
import test.linkedList.SingleLinkedList;

public class MidPointTransferList {
	/// a1->a2->a3->a4->b1->b2->b3->b4 should be changed to
	// a1->b1->a2->b2->a3->b3->a4->b4
	//Complexity O(n) Time
	//O(1) Space
	//NOT WORKING
	public static void main(String[] args) {
		Node head=new Node(10);
		createList(head);
		System.out.println("Before ");
		SingleLinkedList.displayLinkedList(head);
		Node slow=findMiddle(head);
		System.out.println("Slow is "+slow.getValue());
		reArrange(head,slow);
		System.out.println("After ");
		SingleLinkedList.displayLinkedList(head);
	}

	private static void reArrange(Node head, Node slow) {
		Node b=slow.getNext();
		Node pointer =head;
		int i=0;
		//while(slow.getNext().getNext()!=null){
			/*while(b.getNext()!=null){*/
		//Each and every line below is very important
		while(slow!=pointer){
			Node temp=pointer.getNext();
			slow.setNext(b.getNext());
			pointer.setNext(b);
			b.setNext(temp);
			pointer=pointer.getNext().getNext();
			b=slow.getNext();;
			System.out.println("After iteration"+i++);
			SingleLinkedList.displayLinkedList(head);
		}		
	}

	private static Node findMiddle(Node head) {
		Node fast=head.getNext();
		Node slow=head;
		while(fast.getNext()!=null){
			fast=fast.getNext().getNext();
			slow=slow.getNext();
		}
		return slow;
	}

	public static void createList(Node pointerNode) {
		System.out.println("How many number you want to add to list");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner src = new Scanner(System.in);
		int count = src.nextInt();

		System.out.println("Enter " + count + " numbers");
		for (int i = 0; i < count; i++) {
			try {
				Node newNode = new Node(Integer.parseInt(br.readLine()));
				pointerNode.setNext(newNode);
				pointerNode = newNode;
			} catch (IOException e) {
				System.out.println("Found Error");
			}
		}
		pointerNode = null;
		src.close();
	}

}
