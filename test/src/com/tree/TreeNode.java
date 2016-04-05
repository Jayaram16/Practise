package com.tree;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode() {

	}

	public TreeNode(int val) {
		this.val = val;
	}
	
	public String toString(){
		return " "+ this.val;
	}
}
