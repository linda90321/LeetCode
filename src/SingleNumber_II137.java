import java.util.HashMap;

/*Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Hide Tags Bit Manipulation
Hide Similar Problems (M) Single Number (M) Single Number III
 */
public class SingleNumber_II137 {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (map.get(nums[i]) == 2)
					map.remove(nums[i]);
				else
					map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		int res = 0;
		for (int key : map.keySet()) {
			if (map.get(key) == 1)
				res = key;
		}
		return res;
	}
}
