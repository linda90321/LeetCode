import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Hide Company Tags Bloomberg
Hide Tags Array Two Pointers
Hide Similar Problems (M) 3Sum (M) 3Sum Smaller
 */
public class ThreeSumClosest16 {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == target)
					return target;
				else if (sum > target) {
					if (sum - target < min) {
						min = sum - target;
						res = sum;
					}
					end--;
				} else {
					if (target - sum < min) {
						min = target - sum;
						res = sum;
					}
					start++;
				}
			}
		}

		return res;
	}
}
