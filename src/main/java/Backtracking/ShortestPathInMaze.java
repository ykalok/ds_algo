package Backtracking;

import java.util.Scanner;


public class ShortestPathInMaze {
	private static boolean isSafe(int[][] mat, boolean[][] vis, int i, int j) {
		if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 1 && vis[i][j] == false)
			return true;
		return false;
	}

	private static int sortestPathUtils(int[][] mat, boolean[][] vis, int i, int j, int dr, int dc, int minDist,
			int minValue) {
		if (i == dr && j == dc) {
			return Integer.min(minValue, minDist);
		}
		vis[i][j] = true;
		if (isSafe(mat, vis, i + 1, j)) {
			minDist = sortestPathUtils(mat, vis, i+1, j, dr, dc, minDist, minValue + 1);
		}
		if (isSafe(mat, vis, i - 1, j)) {
			minDist = sortestPathUtils(mat, vis, i-1, j, dr, dc, minDist, minValue + 1);
		}
		if (isSafe(mat, vis, i, j + 1)) {
			minDist = sortestPathUtils(mat, vis, i, j+1, dr, dc, minDist, minValue + 1);
		}
		if (isSafe(mat, vis, i, j - 1)) {
			minDist = sortestPathUtils(mat, vis, i, j-1, dr, dc, minDist, minValue + 1);
		}
		vis[i][j] = false;
		return minDist;
	}

	private static int sortestPath(int[][] mat, int i, int j, int dr, int dc) {
		if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[dr][dc] == 0)
			return -1;
		int n = mat.length;
		int m = mat[0].length;
		boolean vis[][] = new boolean[n][m];
		int minDis = sortestPathUtils(mat, vis, i, j, dr, dc, Integer.MAX_VALUE, 0);
		if (minDis != Integer.MAX_VALUE)
			return minDis;
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter size of matrix");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int mat[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				mat[i][j] = x;
			}
		}
//		int mat[][] =
//	        {
//	            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//	            { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//	            { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
//	            { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
//	            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//	            { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
//	            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//	            { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
//	            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//	            { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
//	        };

		int dr = sc.nextInt();
		int dc = sc.nextInt();
		// boolean vis[][]= new boolean[n][n];
		int minDist = sortestPath(mat, 0, 0, dr, dc);
		if (minDist != -1)
			System.out.println("Minimum Distance: " + minDist);
		else {
			System.out.println("Minimum Distance not possible");
		}

	}

}
