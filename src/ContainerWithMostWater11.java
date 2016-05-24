/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

Hide Company Tags Bloomberg
Hide Tags Array Two Pointers
Hide Similar Problems (H) Trapping Rain Water
 */
public class ContainerWithMostWater11 {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int max = 0;
		int start = 0;
		int end = height.length - 1;

		while (start < end) {
			if (height[start] <= height[end]) {
				max = Math.max(max, height[start] * (end - start));
				start++;
			} else {
				max = Math.max(max, height[end] * (end - start));
				end--;
			}
		}

		return max;
	}
}
