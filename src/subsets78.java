import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]*/
public class subsets78 {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(nums, res, temp, 0);
		return res;
	}

	public static void helper(int[] nums, List<List<Integer>> res,
			List<Integer> temp, int pos) {
		res.add(new ArrayList<Integer>(temp));

		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(nums, res, temp, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.print(subsets(nums));
	}
}
