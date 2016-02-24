package test;

public class Node {
	Node left;
	Node right;
	int val;

	public Node(int value) {
		this.val = value;
	}

	
	public String toString(){
		return "Val="+val+" left--->"+ (left!=null?left.val:null) +" right--->"+ (right!=null?right.val:null);		
	}
}
