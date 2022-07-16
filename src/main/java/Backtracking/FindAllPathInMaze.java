package Backtracking;

public class FindAllPathInMaze {

	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };
		int res = findCount(maze, 0, 0, 3, 3);
		System.out.println("Count: " + res);

	}

	private static int findCount(int[][] maze, int i, int j, int dr, int dc) {
		if (maze == null || maze.length == 0 || maze[i][j] == 0 || maze[dr][dc] == 0) {
			return -1;
		}
		int r = maze.length;
		int c = maze[0].length;
		boolean vis[][] = new boolean[r][c];
		int ans = findCountUtils(maze, i, j, dr, dc, vis);
		return ans;
	}

	private static int findCountUtils(int[][] maze, int i, int j, int dr, int dc, boolean[][] vis) {
		if (i == dr && j == dc)
			return 1;
		vis[i][j] = true;
		int count = 0;
		if (isValid(i, j, maze)) {
			if (i + 1 < maze.length && vis[i + 1][j] == false) {
				count += findCountUtils(maze, i + 1, j, dr, dc, vis);
			}
			if (i - 1 >= 0 && vis[i - 1][j] == false) {
				count += findCountUtils(maze, i - 1, j, dr, dc, vis);
			}
			if (j + 1 < maze[0].length && vis[i][j + 1] == false) {
				count += findCountUtils(maze, i, j + 1, dr, dc, vis);
			}
			if (j - 1 >= 0 && vis[i][j - 1] == false) {
				count += findCountUtils(maze, i, j - 1, dr, dc, vis);
			}
		}
		vis[i][j] = false;

		return count;
	}

	private static boolean isValid(int i, int j, int[][] maze) {
		if (i >= 0 && j >= 0 && i <= maze.length && j < maze[0].length && maze[i][j] == 1) {
			return true;
		}
		return false;
	}

}
