import java.util.*;

/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 Hide Tags Array Hash Table Two Pointers
 Hide Similar Problems (E) Two Sum (M) 3Sum
 */
public class FourSum18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					if (sum > target) {
						end--;
					} else if (sum < target) {
						start++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						if (set.contains(temp)) {
							start++;
							end--;
							continue;
						}
						set.add(temp);
						res.add(temp);
					}
				}
			}
		}

		return res;
	}
}
