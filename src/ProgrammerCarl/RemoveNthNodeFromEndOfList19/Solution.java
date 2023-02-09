package ProgrammerCarl.RemoveNthNodeFromEndOfList19;

import 每日一题.ListNode;

/**
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i< n;i++){
            fast = fast.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;
        return dummy.next;
    }
}
