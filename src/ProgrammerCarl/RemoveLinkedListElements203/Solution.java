package ProgrammerCarl.RemoveLinkedListElements203;

import 每日一题.ListNode;

/**
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if(head == null){
            return null;
        }

        ListNode pre = dummy;
        ListNode curr = dummy.next;

        while(curr!=null){
            ListNode next = curr.next;
            if(curr.val == val){
                pre.next = next;
                curr = next;
            } else {
                pre = curr;
                curr = next;
            }
        }
        return dummy.next;
    }
}
