import java.util.HashMap;

/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Hide Similar Problems (M) Single Number (M) Single Number II
 */
public class SingleNumber_III260 {
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.remove(nums[i]);
			} else {
				map.put(nums[i], 1);
			}
		}

		for (int key : map.keySet()) {
			if (map.get(key) == 1) {
				if (res[0] != 0) {
					res[1] = key;
				} else {
					res[0] = key;
				}
			}
		}

		return res;
	}
}
