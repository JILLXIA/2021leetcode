package labuladong.ReverseLinkedListII92;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class Solution {
	ListNode succsor = null;
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left==1){
			return reverseNLinst(head,right);
		} else {
			// 前进到反转的起点
			head.next = reverseBetween(head.next,left-1,right-1);
			return head;
		}
	}
	public ListNode reverseNLinst(ListNode head, int m){
		// recursive the mth linkedList
		if(m==1){
			// 只用记录一个succsor就行了？
			succsor = head.next;
			return head;
		}
		ListNode last = reverseNLinst(head.next,m-1);
		head.next.next = head;
		// 只需要在最后一次附上值
		head.next = succsor;
		return last;
	}
}
