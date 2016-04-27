import java.util.*;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 Hide Company Tags Amazon Microsoft Bloomberg Facebook Adobe
 Hide Tags Array Two Pointers
 Hide Similar Problems (E) Two Sum (M) 3Sum Closest (M) 4Sum (M) 3Sum Smaller
 */
public class ThreeSum15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > 0) {
					end--;
				} else if (sum < 0) {
					start++;
				} else if (sum == 0) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					start++;
					end--;
					if (set.contains(temp)) {
						continue;
					}
					set.add(temp);
					res.add(temp);
				}
			}
		}

		return res;
	}
}
