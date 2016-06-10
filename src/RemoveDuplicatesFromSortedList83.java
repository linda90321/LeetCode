/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Subscribe to see which companies asked this question

Hide Tags Linked List
 */
public class RemoveDuplicatesFromSortedList83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur.next != null) {
			ListNode next = cur.next;
			if (next.val == cur.val) {
				cur = cur.next;
			} else {
				pre.next = cur;
				pre = pre.next;
				cur = cur.next;
			}
		}
		pre.next = cur;

		return dummy.next;
	}
}
