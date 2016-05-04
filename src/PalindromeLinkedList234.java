/*Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Hide Company Tags Amazon Facebook
Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List
 */
public class PalindromeLinkedList234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		// 1.遍历确定长度
		int length = 0;
		ListNode p = head;
		while (p != null) {
			length++;
			p = p.next;
		}
		p = head;// 用完之后, p归位
		if (length == 1) {
			return true;
		}
		// 2.将后半部分链反转
		int half = (length + 1) / 2;
		ListNode q = head;
		for (int i = 0; i < half; i++) {
			q = q.next;
		}
		// 开始反转
		ListNode r = q.next;
		q.next = null;
		ListNode m;
		while (r != null) {
			m = r.next;
			r.next = q;
			q = r;
			r = m;
		}
		// 3.依次比较,直到其中一个或者两个链遍历完
		while (q != null && p != null) {
			if (p.val == q.val) {
				q = q.next;
				p = p.next;
			} else {
				return false;
			}

		}
		return true;
	}
}
