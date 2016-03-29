/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
public class merge_k_SortedLists23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		return helper(lists, 0, lists.length - 1);

	}

	public ListNode helper(ListNode[] lists, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			ListNode left = helper(lists, l, mid);
			ListNode right = helper(lists, mid + 1, r);
			return merge(left, right);
		}

		return lists[l];
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		ListNode head = new ListNode(0);
		ListNode l3 = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l3.next = l1;
				l1 = l1.next;
				l3 = l3.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
				l3 = l3.next;
			}
		}

		if (l1 != null)
			l3.next = l1;

		if (l2 != null)
			l3.next = l2;

		return head.next;
	}
}
