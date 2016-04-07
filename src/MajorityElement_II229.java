import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

 Hint:

 How many majority elements could it possibly have?  <=2
 Do you have a better hint? Suggest it!
 Hide Company Tags Zenefits
 Hide Tags Array
 Hide Similar Problems (E) Majority Element
 */
public class MajorityElement_II229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return res;

		int[] count = new int[2];
		int[] numbers = new int[2];

		numbers[0] = nums[0];
		numbers[1] = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == numbers[0]) {
				count[0]++;
			} else if (nums[i] == numbers[1]) {
				count[1]++;
			} else if (count[0] == 0) {
				numbers[0] = nums[i];
				count[0] = 1;
			} else if (count[1] == 0) {
				numbers[1] = nums[i];
				count[1] = 1;
			} else {
				count[0]--;
				count[1]--;
			}
		}

		Arrays.fill(count, 0);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == numbers[0])
				count[0]++;
			else if (nums[i] == numbers[1])
				count[1]++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > nums.length / 3 && !res.contains(numbers[i])) {
				res.add(numbers[i]);
			}
		}

		return res;
	}
}
