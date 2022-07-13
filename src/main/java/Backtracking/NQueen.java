package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	static int count=0;
	private static void printMatrix(char[][] matrix) {
		for (char[] chars:matrix) {
			System.out.println(Arrays.toString(chars).replaceAll(",", ""));
		}
		
		System.out.println("******************************************");
	}
	
	private static boolean isSafe(char[][] matrix, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (matrix[i][col] == 'Q')
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == 'Q')
				return false;
		}
		for (int i = row, j = col; i >= 0 && j < matrix.length; i--, j++) {
			if (matrix[i][j] == 'Q')
				return false;
		}
		return true;
	}


	private static void nQueen(char[][] matrix, int row) {
		if (row == matrix.length) {
			count++;
			printMatrix(matrix);
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (isSafe(matrix, row, i)) {
				matrix[row][i] = 'Q';
				nQueen(matrix, row + 1);
				matrix[row][i] = '-';
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of matrix");
		int n = sc.nextInt();
		char[][] matrix = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], '-');
		}

		nQueen(matrix, 0);
		System.out.println("Count: "+count);
	}

}
