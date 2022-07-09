package dataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FriendCircles {
	private static void dfsUtils(int[][] adjMatrix,  int sv,boolean[] vis) {
		//System.out.println(sv);
		vis[sv]=true;
		int n= adjMatrix.length;
		for(int i=0;i<n;i++) {
			if(adjMatrix[sv][i]==1 && vis[i]==false) {
				dfsUtils(adjMatrix, i,vis);
			}
		}
		
	}
	
	private static int findCricleNumUsingDfs(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean vis[]= new boolean[n];
		int count =0;
		for(int i=0;i<n;i++) {
			if(vis[i]==false) {
				count++;
				dfsUtils(adjMatrix,i,vis);
			}
		}
		return count;
	}
	
	private static int findCricleNumUsingBfs(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean vis[]= new boolean[n];
		int count =0;
		for(int i=0;i<n;i++) {
			if(vis[i]==false) {
				count++;
				bfsUtils(adjMatrix,i,vis);
			}
		}
		return count;
	}

	private static void bfsUtils(int[][] adjMatrix, int sv, boolean[] vis) {
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(sv);
		vis[sv]=true;
		int v= adjMatrix.length;
		while(!q.isEmpty()) {
			int front =q.poll();
			for(int i=0;i<v;i++) {
				if(adjMatrix[front][i]==1 && vis[i]==false) {
					q.add(i);
					vis[i]=true;
				}
			}
			
		}
		
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
		
		int res = findCricleNumUsingBfs(adjMatrix);
		System.out.println("Bfs count: "+res);
		int num = findCricleNumUsingDfs(adjMatrix);
		System.out.println("Dfs count: "+num);
	}

	
	

}
