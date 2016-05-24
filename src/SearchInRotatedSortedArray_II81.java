/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Subscribe to see which companies asked this question

Hide Tags Array Binary Search
Hide Similar Problems (H) Search in Rotated Sorted Array
*/
public class SearchInRotatedSortedArray_II81 {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (nums[mid] < nums[start]) {
				if (target <= nums[end] && target > nums[mid])
					start = mid + 1;
				else
					end = mid - 1;
			} else
				start++;
		}

		return false;
	}
}
