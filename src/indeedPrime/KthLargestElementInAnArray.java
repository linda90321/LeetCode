package indeedPrime;

import java.util.Collections;
import java.util.PriorityQueue;

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note: 
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
	/*
	 * First of all, put all elements into the heap. Then poll the top k
	 * elements from the max heap then we get the result. The time complexity
	 * for max heap is O(n) + O(k * logn). The space complexity is O(n).
	 */
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length,
				Collections.reverseOrder());

		for (int num : nums) {
			maxHeap.offer(num);
		}

		int result = 0;
		for (int i = 0; i < k; i++) {
			result = maxHeap.poll();
		}

		return result;
	}

}
