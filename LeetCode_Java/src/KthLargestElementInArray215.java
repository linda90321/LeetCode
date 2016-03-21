/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */public class KthLargestElementInArray215 {
	public int findKthLargest(int[] nums, int k) {
		// quick selection
		//Average case time is O(n), worst case time is O(n^2).
		if (nums == null || nums.length == 0)
			return 0;

		return helper(nums, 0, nums.length - 1, nums.length - k);
	}

	public int helper(int[] nums, int lo, int hi, int k) {
		if (lo > hi)
			return nums[lo];

		int pivot = partition(nums, lo, hi);
		if (pivot == k)
			return nums[k];

		if (pivot > k)
			return helper(nums, lo, pivot - 1, k);
		else
			return helper(nums, pivot + 1, hi, k);
	}

	public int partition(int[] nums, int lo, int hi) {
		int pivot = nums[lo];
		int i = lo;
		int j = hi;
		while (i < j) {
			while (i < j && nums[j] >= pivot)
				j--;

			if (i < j)
				swap(nums, i, j);

			while (i < j && nums[i] <= pivot)
				i++;

			if (i < j)
				swap(nums, i, j);

		}

		return i;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
