import java.util.HashSet;

public class validSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		if (board == null)
			return false;
		int row = board.length;
		int col = board[0].length;

		HashSet<Character> set = new HashSet<Character>();
		// Check for each row
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] != '.' && set.contains(board[i][j]))
					return false;
				else if (board[i][j] == '.')
					continue;
				else
					set.add(board[i][j]);
			}
			set.clear();
		}

		// Check for each column
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (board[i][j] != '.' && set.contains(board[i][j]))
					return false;
				else if (board[i][j] == '.')
					continue;
				else
					set.add(board[i][j]);
			}
			set.clear();
		}

		// Check for each sub-grid
		for (int k = 0; k < 9; k++) {
			for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
				for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
					if (board[i][j] != '.' && set.contains(board[i][j]))
						return false;
					else if (board[i][j] == '.')
						continue;
					else
						set.add(board[i][j]);
				}
			}
			set.clear();
		}

		return true;
	}
}
