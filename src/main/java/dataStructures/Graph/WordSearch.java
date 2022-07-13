package dataStructures.Graph;

public class WordSearch {

	public boolean dfs(char[][] board, int i, int j, String word, int count) {
		if (count == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count))
			return false;
		char temp = board[i][j];
		board[i][j] = '#';
		boolean found = dfs(board, i + 1, j, word, count + 1) || dfs(board, i - 1, j, word, count + 1)
				|| dfs(board, i, j + 1, word, count + 1) || dfs(board, i, j - 1, word, count + 1);
		board[i][j] = temp;
		return found;

	}

	public boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
					return true;
			}
		}
		return false;

	}

}
