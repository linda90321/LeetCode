/*A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?

Hide Tags Math Sort
Hide Similar Problems (H) Shortest Distance from All Buildings
 */

/*1. imagine we have a virtual vertical line.
 2. If we move the line to left, the distance of all the elements that on the left column or at the same column with the line, will decrement 1, the other part will increase 1.
 3. So that if the number of element on the left is greater than that on the right, the dist will decrement. We can traverse the column from the left ot right, and find the critical point that cannot decrement dist, which is the best column.
 4. We can use the same rule to deal with rows*/
public class BestMeetingPoint296 {
	public int minTotalDistance(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;

		int[] row = new int[r];
		int[] col = new int[c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					row[i]++;
					col[j]++;
				}
			}
		}

		int minRow = minDis(row);
		int minCol = minDis(col);
		int res = 0;
		for (int i = 0; i < r; i++)
			res += Math.abs(i - minRow) * row[i];
		for (int j = 0; j < c; j++)
			res += Math.abs(j - minCol) * col[j];

		return res;
	}

	public int minDis(int[] arr) {
		int res = 0;
		int first = arr[0];
		int second = 0;
		for (int i = 1; i < arr.length; i++)
			second += arr[i];

		while (first < second) {
			res++;
			first += arr[res];
			second -= arr[res];
		}

		return res;

	}
}
