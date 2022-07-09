package dataStructures.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {
	private int vertex;
	private static List<List<Integer>> list;

	public DetectCycleInDirectedGraph(int vertex) {
		this.vertex = vertex;
		list = new ArrayList<List<Integer>>(vertex);
		 for (int i = 0; i < vertex; i++)
		      list.add(new ArrayList<Integer>());
	}

	// Add edges
	public void addEdge(int s, int d) {
		list.get(s).add(d);
		//list.get(d).add(s);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vertex of graph");
		int v = sc.nextInt();
		DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(v);
		System.out.println("Enter the edges of graph");
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			graph.addEdge(source, dest);
		}
		
		boolean ans = isCycle(list);
		if(ans)
			System.out.println("Cycle is present");
		else {
			System.out.println("Cycle is not present");
		}
	}

	

	private static boolean isCycle(List<List<Integer>> list2) {
		int n=list2.size();
		boolean vis[]=new boolean[n];
		boolean recStack[]=new boolean[n];
		for(int i=0;i<n;i++) {
			if(vis[i]==false) {
				boolean ans = dfsUtils(list2,i,vis,recStack);
				if(ans==true)
					return true;
			}
		}
		return false;
	}

	private static boolean dfsUtils(List<List<Integer>> list2, int sv, boolean[] vis, boolean[] recStack) {
		vis[sv]=true;
		recStack[sv]=true;
		for(Integer i:list2.get(sv)) {
			if(recStack[i]==true)
				return true;
			if(vis[i]==false) {
				boolean ans = dfsUtils(list2,i,vis,recStack);
				if(ans==true)
					return true;
			}
		}
		recStack[sv]=false;
		return false;
	}

}
