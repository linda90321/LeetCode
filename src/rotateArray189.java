/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].*/
public class rotateArray189 {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0)
			return;

		k = k % nums.length;
		swap(nums, 0, nums.length - k - 1);
		swap(nums, nums.length - k, nums.length - 1);
		swap(nums, 0, nums.length - 1);
	}

	public void swap(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}
}
