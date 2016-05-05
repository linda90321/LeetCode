/*Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

Try two pointers.
Did you use the property of "the order of elements can be changed"?
What happens when the elements to remove are rare?
Hide Tags Array Two Pointers
Hide Similar Problems (E) Remove Duplicates from Sorted Array (E) Remove Linked List Elements (E) Move Zeroes
*/
public class RemoveElement27 {
	
/*	public int removeElement(int[] nums, int val) {
		// two pointers
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}*/


    //Two Pointers - when elements to remove are rare
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		int end = nums.length;
		while (i < end) {
			if (nums[i] != val) {
				i++;
			} else {
				nums[i] = nums[end - 1];
				end--;
			}
		}

		return end;
	}
}
