/**
 * 
 */
package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Implements the BFS of the given graph problem
 * 
 * @author Jayaram
 *
 */
public class BFSGraph {
	List<GraphNode> isVisited = new ArrayList<GraphNode>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphNode start = GraphUtility.getGraph();
		BFSGraph obj = new BFSGraph();
		obj.bfs(start);

	}

	void bfs(GraphNode node) {
		Queue<GraphNode> queue = new ArrayDeque<GraphNode>();

		queue.add(node);
		isVisited.add(node);

		while (!queue.isEmpty()) {
			GraphNode n = queue.poll();
			System.out.print(n.val+" ");

			for (GraphNode m : n.neighbors) {
				if (!checkVisited(m)) {
					queue.add(m);
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

