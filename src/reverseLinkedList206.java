/*Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class reverseLinkedList206 {
	public ListNode reverseList(ListNode head) {
		// recursively
		if (head == null)
			return null;

		if (head.next == null) {
			return head;
		}
		ListNode res = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return res;

/*		// iteratively
		if (head == null)
			return null;

		ListNode cur = head;
		ListNode next = head.next;
		cur.next = null;
		while (next != null) {
			ListNode third = next.next;
			next.next = cur;
			cur = next;
			next = third;
		}

		return cur;*/

	}
}
