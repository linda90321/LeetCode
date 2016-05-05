/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

Hide Company Tags LinkedIn Airbnb
Hide Tags Dynamic Programming
Hide Similar Problems (M) Maximum Product Subarray (M) House Robber II (M) Paint House (E) Paint Fence (M) House Robber III
 */
public class HouseRobber198 {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				dp[i] = nums[i];
			else if (i == 1) {
				dp[i] = Math.max(nums[i], nums[i - 1]);
			} else {
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			}

		}

		return dp[nums.length - 1];
	}
}
