package dataStructures.Graph;

import java.util.Scanner;

public class DetectCycleInUndirectedGraph {

	private static boolean dfsUtils(int[][] adjMatrix, int sv, int parent, boolean vis[]) {
		vis[sv] = true;
		parent =sv;
		int n = adjMatrix.length;
		for (int i = 0; i < n; i++) {
			if (adjMatrix[sv][i] == 1) {
				if (vis[i] == false) {
					if (dfsUtils(adjMatrix, i, sv, vis))
						return true;
				} else if (i != parent)
					return true;
			}
		}
		return false;
	}

	private static boolean isCycle(int[][] adjMatrix) {
		int v = adjMatrix.length;
		boolean vis[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (vis[i] == false) {
				if (dfsUtils(adjMatrix, i, -1, vis))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int adjMatrix[][] = new int[v][v];
		int edges = sc.nextInt();
		for (int i = 0; i < edges; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			adjMatrix[s][d] = 1;
			adjMatrix[d][d] = 1;
		}
		if(isCycle(adjMatrix))
			System.out.println("Cycle present");
		else {
			System.out.println("Cycle is Not present");
		}

	}

}
