/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Subscribe to see which companies asked this question

Hide Tags Linked List
Hide Similar Problems (H) Reverse Nodes in k-Group
 */
public class SwapNodesInPairs24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			ListNode next = cur.next;
			ListNode post = next.next;
			pre.next = next;
			cur.next = post;
			next.next = cur;
			pre = cur;
			cur = cur.next;
		}

		return dummy.next;
	}
}
