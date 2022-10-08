package ByteDance.ReverseLinkedList206;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list,
 * reverse the list, and return the reversed list.
 */
public class Solution {
    // recursive
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }

    public ListNode reverse(ListNode cur, ListNode pre){
        if(cur==null){
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        return reverse(next,pre);
    }
}
