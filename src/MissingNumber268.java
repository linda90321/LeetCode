/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Array Math Bit Manipulation
Hide Similar Problems (H) First Missing Positive (M) Single Number (H) Find the Duplicate Number
 */
public class MissingNumber268 {
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum = sum + i - nums[i];

		return sum + nums.length;

	}
}
