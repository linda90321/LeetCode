/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Zenefits
Hide Tags Divide and Conquer Array Bit Manipulation
Hide Similar Problems (M) Majority Element II
 */
public class MajorityElement169 {
    /*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    */
	public int majorityElement(int[] nums) {
		int count = 1;
		int cur = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == cur) {
				count++;
			} else {
				count--;
				if (count == 0) {
					cur = nums[i];
					count = 1;
				}
			}
		}

		return cur;
	}
}
