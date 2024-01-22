package Grind75.ReverseLinkedList206;

import 每日一题.ListNode;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        // do special operation with the first node
        ListNode next = head.next;
        head.next = null;
        return recursive(head,next);
    }

    public ListNode recursive(ListNode head, ListNode next){
        if(next == null) {
            return head;
        }
        ListNode tmp = next.next;
        next.next = head;
        return recursive(next, tmp);
    }
}
