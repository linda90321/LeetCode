/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Hide Company Tags LinkedIn Bloomberg Microsoft
Hide Tags Array Dynamic Programming Divide and Conquer
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Maximum Product Subarray
 */
public class MaximumSubarray53 {
	//Kadane算法，算法复杂度O(n).
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int sum = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			temp += nums[i];
			sum = Math.max(temp, sum);
			if (temp < 0)
				temp = 0;
		}

		return sum;
	}

/*	// 分治法：算法复杂度为O(nlogn)
	public int maxSubArray(int[] A) {
		return divide(A, 0, A.length - 1);
	}

	public int divide(int A[], int low, int high) {
		if (low == high)
			return A[low];
		if (low == high - 1)
			return Math.max(A[low] + A[high], Math.max(A[low], A[high]));

		int mid = (low + high) / 2;
		int lmax = divide(A, low, mid - 1);
		int rmax = divide(A, mid + 1, high);

		int mmax = A[mid];
		int tmp = mmax;
		for (int i = mid - 1; i >= low; i--) {
			tmp += A[i];
			if (tmp > mmax)
				mmax = tmp;
		}
		tmp = mmax;
		for (int i = mid + 1; i <= high; i++) {
			tmp += A[i];
			if (tmp > mmax)
				mmax = tmp;
		}
		return Math.max(mmax, Math.max(lmax, rmax));

	}*/
}
