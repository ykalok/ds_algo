package dataStructures.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
	private int vertex;
	private static List<List<Integer>> list;

	public AdjacencyList(int vertex) {
		this.vertex = vertex;
		list = new ArrayList<List<Integer>>(vertex);
		 for (int i = 0; i < vertex; i++)
		      list.add(new ArrayList<Integer>());
	}

	// Add edges
	public void addEdge(int s, int d) {
		list.get(s).add(d);
		list.get(d).add(s);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vertex of graph");
		int v = sc.nextInt();
		AdjacencyList graph = new AdjacencyList(v);
		System.out.println("Enter the edges of graph");
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			graph.addEdge(source, dest);
		}

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < v; i++) {
			s.append(i + ": ");
			for (int j: list.get(i)) {
				s.append((j !=0 ? j : 0) + " ");
			}
			s.append("\n");
		}
		s.toString();
		System.out.println(s);
	}

}
