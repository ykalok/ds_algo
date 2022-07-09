package dataStructures.Graph;

import java.util.Scanner;

public class AdjacencyMatrix {
	private int vertex;
	private static int adjMatrix[][];

	public AdjacencyMatrix(int vertex) {
		this.vertex = vertex;
		adjMatrix = new int[vertex][vertex];
	}

	// Add edges
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}

	// Remove edges
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vertex of graph");
		int v = sc.nextInt();
		AdjacencyMatrix graph = new AdjacencyMatrix(v);
		System.out.println("Enter the edges of graph");
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			graph.addEdge(source, dest);
			graph.addEdge(dest, source);
		}

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < v; i++) {
			s.append(i + ": ");
			for (int j : adjMatrix[i]) {
				s.append((j == 1 ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		s.toString();
		System.out.println(s);
	}

}
