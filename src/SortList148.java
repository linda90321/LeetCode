/*Sort a linked list in O(n log n) time using constant space complexity.

Hide Tags Linked List Sort
Hide Similar Problems (E) Merge Two Sorted Lists (M) Sort Colors (M) Insertion Sort List
 */
public class SortList148 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode firsthalf = head;
		ListNode secondhalf = slow.next;
		slow.next = null;

		ListNode leftlist = null, rightlist = null;
		if (firsthalf != secondhalf) {
			leftlist = sortList(firsthalf);
			rightlist = sortList(secondhalf);
		}
		return mergeTwoLists(leftlist, rightlist);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
