/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.



Subscribe to see which companies asked this question

Hide Tags Backtracking
Hide Similar Problems (H) N-Queens
 */
import java.util.*;

public class N_Queens_II52 {
	int count = 0;

	public int totalNQueens(int n) {
		if (n == 0)
			return 0;

		dfs(n, 0, new int[n]);
		return count;
	}

	public void dfs(int n, int row, int[] colValid) {
		if (row == n) {
			count++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValid(colValid, row, col)) {
				colValid[row] = col;
				dfs(n, row + 1, colValid);
			}
		}
	}

	public boolean isValid(int[] colValid, int row, int col) {
		for (int r = 0; r < row; r++) {
			if ((col == colValid[r])
					|| (row - r == Math.abs(col - colValid[r])))
				return false;
		}
		return true;
	}
/*	public int totalNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (n == 0)
			return 0;

		char[][] curr = new char[n][n];
		for (char[] row : curr)
			Arrays.fill(row, '.');

		boolean[] col_occupied = new boolean[n];
		help(res, curr, col_occupied, 0, n);
		return res.size();
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
	}*/
}
