package ProgrammerCarl.ReverseLinkedList206;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list,
 * reverse the list, and return the reversed list.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // d -> 1 -> 2 -> 3
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
