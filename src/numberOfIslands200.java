/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3*/
public class numberOfIslands200 {
	 public int numIslands(char[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        int rows = grid.length;
	        int cols = grid[0].length;
	         
	        boolean[][] visited = new boolean[rows][cols];
	        int result = 0;
	         
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (grid[i][j] == '1' && !visited[i][j]) {
	                    result++;
	                    helper(grid, visited, i, j, rows, cols);
	                }
	            }
	        }
	         
	        return result;
	    }
	     
	    private void helper(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
	        if (i < 0 || i >= row) {
	            return;
	        }
	         
	        if (j < 0 || j >= col) {
	            return;
	        }
	         
	        if (visited[i][j]) {
	            return;
	        }
	         
	        // If water
	        if (grid[i][j] == '0') {
	            return;
	        }
	         
	        // Mark the visted[i][j] = true
	        visited[i][j] = true;
	         
	        // Go up, down, left and right
	        helper(grid, visited, i - 1, j, row, col);
	        helper(grid, visited, i + 1, j, row, col);
	        helper(grid, visited, i, j - 1, row, col);
	        helper(grid, visited, i, j + 1, row, col);
	    }
}
