package labuladong.ReverseLinkedList206;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list,
 * reverse the list, and return the reversed list.
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		// recursive
		if(head==null || head.next==null){
			return head;
		}
		ListNode last = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
}
