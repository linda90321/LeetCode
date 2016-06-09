/*The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Subscribe to see which companies asked this question

Hide Tags Backtracking
Hide Similar Problems (H) N-Queens II
 */
import java.util.*;
public class N_Queens51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (n == 0)
			return res;

		char[][] curr = new char[n][n];
		for (char[] row : curr)
			Arrays.fill(row, '.');

		boolean[] col_occupied = new boolean[n];
		help(res, curr, col_occupied, 0, n);
		return res;
	}

	public void help(List<List<String>> res, char[][] curr,
			boolean[] col_occupied, int r, int n) {
		if (r == n) {
			List<String> list = new ArrayList<String>();
			for (char[] row : curr)
				list.add(new String(row));
			res.add(list);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(curr, col_occupied, r, i, n)) {
				curr[r][i] = 'Q';
				col_occupied[i] = true;
				help(res, curr, col_occupied, r + 1, n);
				curr[r][i] = '.';
				col_occupied[i] = false;
			}
		}
	}

	public boolean isValid(char[][] curr, boolean[] col_occupied, int row,
			int col, int n) {
		if (col_occupied[col])
			return false;

		for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
			if (curr[row - i][col - i] == 'Q')
				return false;
		}
		for (int i = 1; row - i >= 0 && col + i < n; i++) {
			if (curr[row - i][col + i] == 'Q')
				return false;
		}

		return true;
	}
}
