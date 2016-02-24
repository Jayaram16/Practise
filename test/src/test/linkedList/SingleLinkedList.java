package test.linkedList;

import java.util.Arrays;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SingleLinkedList {

	public static void main(String ar[]) {
		Node parent = new Node(13);
		createList(parent);
		displayLinkedList(parent);
		System.out.println("Display reverse order");
		displayLinkedList(reverseList(parent));
	}

	public static Node reverseList(Node pointerNode) {
		Node anotherNode =null;
		if (pointerNode != null) {
			Node oldAnotherNode=null;
			anotherNode = new Node(pointerNode.getValue());
			anotherNode.setNext(oldAnotherNode);
			oldAnotherNode=anotherNode;
			while (pointerNode.getNext() != null) {
				anotherNode = new Node(pointerNode.getNext().getValue());
				anotherNode.setNext(oldAnotherNode);
				pointerNode = pointerNode.getNext();
				oldAnotherNode=anotherNode;
			}
		}
		return anotherNode;
	}

	public static void displayLinkedList(Node node) {
		System.out.println("The list value is ");
		do {
			System.out.print(node.getValue() + " ");
			node = node.getNext();
		} while (node != null);
		System.out.println();
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
