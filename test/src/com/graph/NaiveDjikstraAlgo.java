package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This algo is naive because it uses a space of N^2 and time of n^2 as well.
 * Plus this algo only calculates from first node that with a number 1 only. An
 * upgraded algorithm is required to remove this shortcomings.
 */
public class NaiveDjikstraAlgo {

	public static final int INFINITY = 32767;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices");
		int numVertices = Integer.parseInt(br.readLine());
		System.out.println("Enter the number of edges");
		int numEdges = Integer.parseInt(br.readLine());
		int[][] matrix = new int[numVertices + 1][numVertices + 1];
		for (int i = 0; i <= numVertices; i++) {
			for (int j = 0; j <= numVertices; j++) {
				matrix[i][j] = NaiveDjikstraAlgo.INFINITY;
			}
		}
		for (int k = 0; k < numEdges; k++) {
			System.out.println("Enter the first vertex");
			int i = Integer.parseInt(br.readLine());
			System.out.println("Enter the second vertex");
			int j = Integer.parseInt(br.readLine());
			System.out.println("Enter the cost");
			int cost = Integer.parseInt(br.readLine());
			matrix[i][j] = matrix[j][i] = cost;
		}
		int result[] = new NaiveDjikstraAlgo().callDjikstra(matrix, numVertices);
		System.out.println("The weight array is ");
		System.out.println(Arrays.toString(result));
		System.out.println("The total matrix is ");
		for (int i =0 ; i <= numVertices; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	private int[] callDjikstra(int[][] matrix, int m) {
		int[] vertices = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			vertices[i] = INFINITY;
		}
		vertices[0] = 0;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= m; j++) {
				if (matrix[i][j] != INFINITY) {
					vertices[j] = Math.min(vertices[i] + matrix[i][j], vertices[j]);
				}
			}
		}
		return vertices;
	}

}
