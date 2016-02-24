package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgo {

	public static void main(String a[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Enter the number of edges");
		int n = Integer.parseInt(br.readLine());
		List<Edge> edgeList = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			Edge e = new Edge();
			System.out.println("Enter the first vertex");
			e.vertexA = Integer.parseInt(br.readLine());
			System.out.println("Enter the second vertex");
			e.vertexB = Integer.parseInt(br.readLine());
			System.out.println("Enter the cost");
			e.cost = Integer.parseInt(br.readLine());
			edgeList.add(e);
		}
		Collections.sort(edgeList);
		System.out.println(new KruskalsAlgo().findMst(edgeList, m));
	}

	private List<Edge> findMst(List<Edge> edgeList, int vertexNumber) {
		List<Edge> mst = new ArrayList<Edge>();
		int cost=0;
		boolean vertexArray[] = new boolean[vertexNumber + 1];
		for (Edge e : edgeList) {
			if (vertexArray[e.vertexA] && vertexArray[e.vertexB]) {
				continue;
			} else {
				vertexArray[e.vertexA] = true;
				vertexArray[e.vertexB] = true;
				cost+=e.cost;
				mst.add(e);
			}
		}
		System.out.println("The total cost of the MST is "+ cost);
		return mst;
	}
}

class Edge implements Comparable<Edge> {
	int vertexA;
	int vertexB;
	int cost;

	public Edge() {

	}

	public Edge(int a, int b, int c) {
		vertexA = a;
		vertexB = b;
		cost = c;
	}

	public int compareTo(Edge e) {
		// Ascending order
		return this.cost - e.cost;
		//Descending order
		//return e.cost - this.cost;
	}

	public String toString() {
		return "{ " + vertexA + " <--> " + vertexB + " : " + cost + " };";
	}
}
