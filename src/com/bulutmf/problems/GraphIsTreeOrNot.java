package com.bulutmf.problems;

import java.util.HashMap;
import java.util.Stack;

public class GraphIsTreeOrNot {

	/**
	 * Q: Check if a given directed graph is a tree or not
	 * A: The graph is a tree if it's acyclic and connected. So we need to check both conditions
	 * 		To do this, we can use DFS and see if a visited node visited again and if a node has not
	 * 		been visited at all. 
	 */
	public static void main(String[] args) {
		
		int[] vertices = {1,2,3,4,5};
		HashMap<Integer, int[]> adjList = new HashMap<>();
		adjList.put(1, new int[]{2});
		adjList.put(2, new int[]{3,4});
		adjList.put(4, new int[]{5});
		
		System.out.println("Is tree: " + (isTree(vertices, adjList)?"yes":"no"));
	}

	private static boolean isTree(int[] vertices, HashMap<Integer, int[]> adjList) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(vertices[0]);
		
		while (!stack.isEmpty()) {
			int node = stack.pop();
			visited.put(node, true);
			int[] adjNodes = adjList.get(node);
			if (adjNodes != null) {
				for (int n : adjNodes) {
					if (visited.containsKey(n)) {
						return false;
					}
					stack.push(n);
				}
			}
		}
		
		for (int n : vertices) {
			if (!visited.containsKey(n))
				return false;
		}
		
		return true;
	}
}
