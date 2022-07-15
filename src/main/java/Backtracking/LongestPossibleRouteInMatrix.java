package Backtracking;

import java.util.Scanner;

public class LongestPossibleRouteInMatrix {


	private static boolean isSafe(int[][] mat, boolean[][] vis, int i, int j) {
		if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 1 && vis[i][j] == false)
			return true;
		return false;
	}

	private static int longestPathUtils(int[][] mat, boolean[][] vis, int i, int j, int dr, int dc, int maxDist,
			int dist) {
		if (mat[i][j] == 0) {
            return 0;
        }
		if (i == dr && j == dc) {
			return Integer.max(dist, maxDist);
		}
		vis[i][j] = true;
		if (isSafe(mat, vis, i + 1, j)) {
			maxDist = longestPathUtils(mat, vis, i+1, j, dr, dc, maxDist, dist + 1);
		}
		if (isSafe(mat, vis, i - 1, j)) {
			maxDist = longestPathUtils(mat, vis, i-1, j, dr, dc, maxDist, dist + 1);
		}
		if (isSafe(mat, vis, i, j + 1)) {
			maxDist = longestPathUtils(mat, vis, i, j+1, dr, dc, maxDist, dist + 1);
		}
		if (isSafe(mat, vis, i, j - 1)) {
			maxDist = longestPathUtils(mat, vis, i, j-1, dr, dc, maxDist, dist + 1);
		}
		vis[i][j] = false;
		return maxDist;
	}

	private static int sortestPath(int[][] mat, int i, int j, int dr, int dc) {
		if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[dr][dc] == 0)
			return -1;
		int n = mat.length;
		int m = mat[0].length;
		boolean vis[][] = new boolean[n][m];
		int maxDis = longestPathUtils(mat, vis, i, j, dr, dc, 0, 0);
		return maxDis;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Eneter size of matrix");
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int mat[][] = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				int x = sc.nextInt();
//				mat[i][j] = x;
//			}
//		}
		 // input matrix
        int mat[][] =
                {
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
                };

		int dr = sc.nextInt();
		int dc = sc.nextInt();
		// boolean vis[][]= new boolean[n][n];
		int minDist = sortestPath(mat, 0, 0, dr, dc);
		
		System.out.println("Maximum Distance: " + minDist);
	
	}



}
