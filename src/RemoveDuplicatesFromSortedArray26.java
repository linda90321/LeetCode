/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

Hide Company Tags Microsoft Bloomberg Facebook
Hide Tags Array Two Pointers
Hide Similar Problems (E) Remove Element
 */
public class RemoveDuplicatesFromSortedArray26 {
/*	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int dup = nums[0];

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != dup) {
				i++;
				nums[i] = nums[j];
				dup = nums[j];
			}
		}
		return i + 1;
	}*/
	
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
