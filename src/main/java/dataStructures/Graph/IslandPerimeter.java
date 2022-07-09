package dataStructures.Graph;

public class IslandPerimeter {

	int count = 0;

	public int islandPerimeter(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					dfsFill(grid, i, j);
					break;
				}
			}
		}
		return count;

	}

	public void dfsFill(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			count++;
			return;
		}
		if (grid[i][j] == -1)
			return;
		else {
			grid[i][j] = -1;
			dfsFill(grid, i + 1, j);
			dfsFill(grid, i, j + 1);
			dfsFill(grid, i - 1, j);
			dfsFill(grid, i, j - 1);
		}

	}

}
