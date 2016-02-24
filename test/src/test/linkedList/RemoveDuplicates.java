package test.linkedList;
/**
 * 
 * @author Jayaram
 *Check the file in src\crackCodingInterview\RemoveDuplicates.java. That has the correct answer. This doesnt have correct answer
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		Node n = new Node(10);
		createNodeList(n);
		displayNode(n);

		removeDuplicates(n);
		displayNode(n);
	}

	private static void displayNode(Node n) {
		while(n!=null){
			System.out.print(n.getValue()+"-->");
			n=n.getNext();
		}
		
	}

	private static void removeDuplicates(Node n) {
		Node firstNode = n;
		Node fastRunner = n.getNext();
		Node medRunner = n;
		//while (firstNode != null) {
			while (fastRunner != null) {
				if (firstNode.getValue() == fastRunner.getValue()) {
					medRunner.setNext(fastRunner.getNext());
				}else{
					medRunner=medRunner.getNext();
				}
				fastRunner = fastRunner.getNext();
			}
			fastRunner = firstNode.getNext();
			medRunner = firstNode;
	//	}	

	}

	private static void createNodeList(Node node) {
		node.setNext(new Node(5));
		node.getNext().setNext(new Node(5));
		node.getNext().getNext().setNext(new Node(12));
		node.getNext().getNext().getNext().setNext(new Node(10));
		node.getNext().getNext().getNext().getNext().setNext(null);
	}

}
