/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Hide Company Tags LinkedIn
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self
*/

//http://buttercola.blogspot.com/2015/08/leetcode-maximum-product-subarray.html
public class MaximumProductSubarray152 {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = nums[0];
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curMin = Math.min(nums[i],
					Math.min(min * nums[i], max * nums[i]));
			int curMax = Math.max(nums[i],
					Math.max(max * nums[i], min * nums[i]));
			min = curMin;
			max = curMax;

			res = Math.max(max, res);
		}

		return res;
	}
    /*
    Follow-up: 
How about the maximum product subsequence? For example, 2 -3 4, the result is 2 * 4 = 8

The solution would be very similar to the maximum product subarray. The only difference is max and min do not necessary include the nums[i]. Therefore, 
min = Min(min, min * nums[i], max * nums[i], nums[i]);
max = Max(max, max * nums[i], min * nums[i], nums[i]);
result = Max(result, max);
*/
}
