import java.util.*;

/*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]
 Follow up:
 Could you solve it in O(n2) runtime?

 Hide Company Tags Google
 Hide Tags Array Two Pointers
 Hide Similar Problems (M) 3Sum (M) 3Sum Closest
 */
public class ThreeSumSmaller259 {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum < target) {
					count += end - start;
					start++;
				} else {
					end--;
				}
			}
		}

		return count;
	}
}
