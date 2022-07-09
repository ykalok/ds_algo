package dataStructures.Graph;

import java.util.Scanner;

public class DFS {
	private static void dfsUtils(int[][] adjMatrix, boolean[] vis, int sv) {
		System.out.println(sv);
		vis[sv]=true;
		int n= adjMatrix.length;
		for(int i=0;i<n;i++) {
			if(adjMatrix[sv][i]==1 && vis[i]==false) {
				dfsUtils(adjMatrix, vis, i);
			}
		}
		
	}
	private static void dfs(int[][] adjMatrix) {
		int v=adjMatrix.length;
		boolean vis[]=new boolean[v];
		for(int i=0;i<v;i++) {
			if(vis[i]==false)
				dfsUtils(adjMatrix,vis,i);
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v= sc.nextInt();
		int adjMatrix[][]= new int[v][v];
		int edges = sc.nextInt();
		for(int i=0;i<edges;i++) {
			int s=sc.nextInt();
			int d = sc.nextInt();
			adjMatrix[s][d]=1;
			adjMatrix[d][d]=1;
		}
		
		dfs(adjMatrix);

	}

}
