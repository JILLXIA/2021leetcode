package Grind75.ReverseLinkedListII92;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list and
 * two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right,
 * and return the reversed list.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;
        ListNode curr = head;

        int count = 1;

        while(curr != null && count != left) {
            pre = curr;
            curr = curr.next;
            count++;
        }
        ListNode start = curr;
        ListNode tmpPre = null;
        while(curr != null && count != right+1) {
            ListNode next = curr.next;
            curr.next = tmpPre;
            tmpPre = curr;
            curr = next;
            count++;
        }

        pre.next = tmpPre;
        start.next = curr;
        return dummy.next;
    }
}
