package dataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	private static void bfsUtils(int[][] adjMatrix, boolean[] vis, int sv) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(sv);
		vis[sv]=true;
		int n =adjMatrix.length;
		while(!q.isEmpty()) {
			int val=q.poll();
			System.out.println(val);
			for(int i=0;i<n;i++) {
				if(adjMatrix[val][i]==1 && vis[i]==false) {
					vis[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	private static void bfs(int[][] adjMatrix) {
		int v=adjMatrix.length;
		boolean vis[]=new boolean[v];
		for(int i=0;i<v;i++) {
			if(vis[i]==false)
				bfsUtils(adjMatrix,vis,i);
			
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
		
		bfs(adjMatrix);

	}

}
