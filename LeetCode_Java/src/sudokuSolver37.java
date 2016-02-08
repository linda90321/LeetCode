public class sudokuSolver37 {

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		helper(board);
	}

	public boolean helper(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValid(board, i, j, num)) {
							board[i][j] = num;
							if (helper(board))
								return true;
							else
								board[i][j] = '.';
						}

					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int i, int j, char num) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][j] == num)
				return false;
		}

		for (int col = 0; col < board[0].length; col++) {
			if (board[i][col] == num)
				return false;
		}

		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				if (board[row][col] == num)
					return false;
			}
		}

		return true;
	}

}