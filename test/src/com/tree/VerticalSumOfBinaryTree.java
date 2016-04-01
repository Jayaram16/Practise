package com.tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * print vertical sum of binary tree nodes in java. Read more at
 * http://www.java2blog.com/2015/11/vertical-sum-of-binary-tree-in-java.html
 * 
 * @author Jayaram
 *
 */
public class VerticalSumOfBinaryTree {
	//

	public static void main(String[] args) {
		Node root = new Node(40);
		root.left = new Node(20);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.right = new Node(30);
		root.left.right.left = new Node(5);
		root.right.left = new Node(50);
		root.right.right = new Node(70);
		root.right.left.right = new Node(55);
		VerticalSumOfBinaryTree obj = new VerticalSumOfBinaryTree();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		obj.verticalSum(root, 0,map);
		for (Entry<Integer, Integer> val : map.entrySet()) {
			System.out.println("key " + val.getKey() + " : " + val.getValue());
		}
	}

	public void verticalSum(Node root, int key,Map<Integer,Integer> map) {
		if (root == null) {
			return;
		}
		if (map.containsKey(key)) {
			int val = map.get(key);
			map.put(key, val + root.data);
		} else {
			map.put(key, root.data);
		}
		verticalSum(root.left, key - 1,map);
		verticalSum(root.right, key + 1,map);
	}
}
