/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Hide Company Tags Bloomberg
Hide Tags Linked List Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary
 */
public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode res = new ListNode(0);
		ListNode dummy = res;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int tempSum = x + y + carry;
			dummy.next = new ListNode(tempSum % 10);
			dummy = dummy.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
			carry = tempSum / 10;
		}

		if (carry > 0)
			dummy.next = new ListNode(carry);

		return res.next;
	}
}
