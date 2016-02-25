/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class rotateImage48 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
				matrix[n - 1 - j][n - 1 - i] = temp;

			}

		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}

	}
}
