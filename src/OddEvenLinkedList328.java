/*Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

Credits:
Special thanks to @DjangoUnchained for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Linked List
 */
public class OddEvenLinkedList328 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode evenHead = p2;
		while (p2 != null && p2.next != null) {
			p1.next = p2.next;
			p1 = p1.next;
			p2.next = p1.next;
			p2 = p2.next;
		}

		p1.next = evenHead;

		return head;
	}
}
