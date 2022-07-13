package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class KnightTours {
	static int count=0;

	public static final int[] dirX = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static final int[] dirY = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of matrix");
		int n = sc.nextInt();
		int vis[][] = new int[n][n];
		knightTour(vis,0,0,1);
		System.out.println("Count: "+count);

	}

	private static void knightTour(int[][] vis, int i, int j, int pos) {
		if(pos>=vis.length*vis.length) {
			printKnightTours(vis);
			count++;
			return;
		}
		for(int k=0;k<8;k++) {
			vis[i][j]=pos;
			int x=i+dirX[k];
			int y=j+dirY[k];
			//System.out.println(x+" ");
			if(isSafe(vis,x,y) && vis[x][y]==0) {
				knightTour(vis,x,y,pos+1);
			}
		}
		vis[i][j]=0;
		
	}

	private static void printKnightTours(int[][] vis) {
		for(int x[]:vis) {
			System.out.println(Arrays.toString(x));
			System.out.println();
		}
		System.out.println("***********************");
	}

	private static boolean isSafe(int[][] vis, int x, int y) {
		if(x<0 || x>=vis.length || y<0 || y>=vis.length)
			return false;
		return true;
	}

}
