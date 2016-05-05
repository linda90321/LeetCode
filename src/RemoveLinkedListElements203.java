/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Tags Linked List
Hide Similar Problems (E) Remove Element (E) Delete Node in a Linked List
 */
public class RemoveLinkedListElements203 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}
