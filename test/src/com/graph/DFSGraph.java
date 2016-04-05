/**
 * 
 */
package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implements the BFS of the given graph problem
 * 
 * @author Jayaram
 *
 */
public class DFSGraph {
	List<GraphNode> isVisited = new ArrayList<GraphNode>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphNode start = GraphUtility.getGraph();
		DFSGraph obj = new DFSGraph();
		obj.bfs(start);

	}

	void bfs(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();

		stack.push(node);
		isVisited.add(node);

		while (!stack.isEmpty()) {
			GraphNode n = stack.pop();
			System.out.print(n.val + " ");
			for (GraphNode m : n.neighbors) {
				if (!checkVisited(m)) {
					stack.push(m);
				}
			}

		}
	}

	private boolean checkVisited(GraphNode m) {
		if (isVisited.contains(m)) {
			return true;
		} else {
			isVisited.add(m);
			return false;
		}
	}

}
