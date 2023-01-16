package ProgrammerCarl.RemoveLinkedListElements203;

import 每日一题.ListNode;

public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        // recursive
        if(head == null){
            return null;// edge case: when move to the end of 
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
