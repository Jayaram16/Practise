package com.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtility {

	/**
	 * 1-----3---- |\ | | \ | | 2-----4 5---+ | +------6--+
	 */
	public static GraphNode getGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);
		List<GraphNode> oneList = new ArrayList<GraphNode>();
		oneList.add(five);
		oneList.add(two);
		oneList.add(three);
		one.neighbors = oneList;

		List<GraphNode> twoList = new ArrayList<GraphNode>();
		twoList.add(one);
		twoList.add(five);
		twoList.add(four);
		two.neighbors = twoList;

		List<GraphNode> threeList = new ArrayList<GraphNode>();
		threeList.add(one);
		threeList.add(four);
		three.neighbors = threeList;

		List<GraphNode> fourList = new ArrayList<GraphNode>();
		fourList.add(two);
		fourList.add(three);
		fourList.add(six);
		four.neighbors = fourList;

		List<GraphNode> fiveList = new ArrayList<GraphNode>();
		fiveList.add(one);
		fiveList.add(two);
		fiveList.add(six);
		five.neighbors = fiveList;

		List<GraphNode> sixList = new ArrayList<GraphNode>();
		sixList.add(four);
		sixList.add(five);
		six.neighbors = sixList;

		return one;
	}
}

class GraphNode {
	int val;
	List<GraphNode> neighbors;

	GraphNode(int val) {
		this.val = val;
	}

	public String toString() {
		return String.valueOf(val);
	}
}
